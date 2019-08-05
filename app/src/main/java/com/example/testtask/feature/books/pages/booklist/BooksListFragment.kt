package com.example.testtask.feature.books.pages.booklist

import android.os.Bundle
import androidx.appcompat.widget.SearchView
import android.view.*
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.testtask.R
import com.example.testtask.base.framework.CoreFragment
import com.example.testtask.di.modules.BaseFragmentModule
import com.example.testtask.feature.books.BooksActivity
import com.example.testtask.feature.books.domain.model.BookModel
import com.example.testtask.feature.books.pages.booklist.adapter.BooksListAdapter
import com.example.testtask.feature.books.pages.booklist.adapter.ChipsAdapter
import com.example.testtask.feature.books.pages.booklist.mvp.BooksListPresenter
import com.example.testtask.feature.books.pages.booklist.mvp.BooksListView
import com.example.testtask.feature.books.pages.booklist.mvp.model.YearItem
import com.example.testtask.tools.ResourcesProvider
import com.example.testtask.tools.listbuilder.AdapterList
import com.example.testtask.tools.listbuilder.ListBuilderDirector
import com.example.testtask.tools.listbuilder.concretebuilders.NoDividerHorizontalListBuilder
import com.example.testtask.tools.listbuilder.concretebuilders.SpacingDividerGridListBuilder
import com.tylersuehr.esr.EmptyStateRecyclerView
import kotlinx.android.synthetic.main.layout_list_fragment.*
import javax.inject.Inject


class BooksListFragment : CoreFragment(), BooksListView {

    @Inject
    @InjectPresenter
    lateinit var presenter: BooksListPresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    @Inject
    lateinit var director: ListBuilderDirector<BookModel>

    @Inject
    lateinit var chipsDirector: ListBuilderDirector<YearItem>

    @Inject
    lateinit var resourcesProvider: ResourcesProvider

    private var searchView: SearchView? = null
    private var searchText: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        (activity as BooksActivity).booksComponent
            .booksListComponent(BaseFragmentModule(this)).inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
            inflater.inflate(R.layout.layout_list_fragment, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initDefaultToolbar()
        setTitle("Книги")
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.search_menu, menu)
        searchView = (menu.findItem(R.id.menu_search).actionView as SearchView)
        searchView?.setQuery(searchText, true)
        searchView?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

            override fun onQueryTextChange(query: String): Boolean {
                searchText = query
                presenter.onSearchQueryChanged(query)
                return false
            }
        })
    }

    override fun showLoader(show: Boolean) {
        rvList.invokeState(
            if (show) {
                EmptyStateRecyclerView.STATE_LOADING
            } else {
                EmptyStateRecyclerView.STATE_OK
            })
    }

    override fun showError(throwable: Throwable) {
        rvList.invokeState(EmptyStateRecyclerView.STATE_ERROR)
    }

    override fun showList(items: AdapterList<BookModel>) {
        director
            .setBuilder(SpacingDividerGridListBuilder(2, 8))
            .build(
                rvList,
                items) { list ->
                BooksListAdapter(list, resourcesProvider) { item ->
                    presenter.onItemClick(item)
                }
            }
    }

    override fun showEmptyList() {
        rvList.invokeState(EmptyStateRecyclerView.STATE_EMPTY)
    }

    override fun invokeOkListState() {
        rvList.invokeState(EmptyStateRecyclerView.STATE_OK)
    }

    override fun showChipsList(items: AdapterList<YearItem>) {
        chipsDirector
            .setBuilder(NoDividerHorizontalListBuilder())
            .build(
                rvChipsList,
                items) { list ->
                ChipsAdapter(list) { item ->
                    presenter.onChipPressed(item)
                }
            }

    }
}