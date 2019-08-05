package com.example.testtask.base.framework

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.testtask.R
import com.example.testtask.base.navigation.SupportAppNavigator
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import javax.inject.Inject

abstract class CoreActivity : AppCompatActivity() {

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    protected open lateinit var ciceroneNavigator: Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initCiceroneNavigator()
    }

    override fun onStart() {
        super.onStart()
        navigatorHolder.setNavigator(ciceroneNavigator)
    }

    override fun onStop() {
        navigatorHolder.removeNavigator()
        super.onStop()
    }

    protected abstract fun setResultListeners()

    protected abstract fun createFragmentForCiceroneNavigator(screenKey: String, data: Any?): Fragment?

    protected abstract fun createIntentForCiceroneNavigator(context: Context, screenKey: String, data: Any?): Intent?

    protected open fun createCiceroneNavigator(): Navigator {
        return object : SupportAppNavigator(this, R.id.flContentContainer) {


            override fun createActivityIntent(context: Context, screenKey: String, data: Any?): Intent? {
                return createIntentForCiceroneNavigator(context, screenKey, data)
            }

            override fun createFragment(screenKey: String, data: Any?): Fragment {
                return createFragmentForCiceroneNavigator(screenKey, data) ?: Fragment()
            }

            override fun showSystemMessage(message: String) {
                Toast.makeText(this@CoreActivity, message, Toast.LENGTH_SHORT).show()
            }

            override fun exit() {
                super.exit()
                navigatorHolder.removeNavigator()
            }
        }
    }

    private fun initCiceroneNavigator() {
        setResultListeners()
        ciceroneNavigator = createCiceroneNavigator()
    }

    override fun onBackPressed() {
        router.exit()
    }
}