package com.pozzo.teamwork.architecture.mvp

import android.os.AsyncTask
import java.lang.ref.WeakReference

/**
 * Provides basic abstraction of a presenter, should improve development speed by implementing
 *  generic functionalities and development tools.
 * Should also tend to help maintaining implementation similar through the application.
 *
 * @since 27/07/17.
 */
abstract class BasePresenter<V : BaseView> {
    private var view: WeakReference<V>? = null

    fun takeView(view: V) {
        if (this.view != null) {
            dropView()
        }

        this.view = WeakReference(view)
        onLoad()
    }

    fun dropView() {
        this.view = null
    }

    protected fun getView(): V? {
        return view?.get()
    }

    protected abstract fun onLoad()

    /**
     * Run backgroundTask while displaying visual load feedback.
     */
    protected fun runInBackground(backgroundTask: () -> Unit, postTask: (() -> Unit)? = null) {
        object: AsyncTask<Unit, Unit, Throwable?>() {
            override fun onPreExecute() {
                getView()?.showLoading()
            }

            override fun doInBackground(vararg p0: Unit?): Throwable? {
                try {
                    backgroundTask()
                } catch (e: Throwable) {
                    return e
                    //todo attach report system
                }
                return null
            }

            override fun onPostExecute(result: Throwable?) {
                if (result != null) {
                    getView()?.error(result)
                }
                if (postTask != null) {
                    postTask()
                }
                getView()?.hideLoading()
            }
        }.execute()
    }
}
