package com.pozzo.teamwork.architecture.mvp

import android.os.AsyncTask
import java.lang.ref.WeakReference

/**
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
        object: AsyncTask<Unit, Unit, Unit>() {
            override fun onPreExecute() {
                getView()?.showLoading()
            }

            override fun doInBackground(vararg p0: Unit?): Unit {
                try {
                    backgroundTask()
                } catch (e: Throwable) {
                    e.printStackTrace()
                    //todo create default interface for unknown error
                    //todo attach report system
                }
            }

            override fun onPostExecute(result: Unit?) {
                if (postTask != null) {
                    postTask()
                }
                getView()?.hideLoading()
            }
        }.execute()
    }
}
