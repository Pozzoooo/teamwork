package com.pozzo.teamwork.project.list

import android.app.FragmentManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.pozzo.teamwork.R
import com.pozzo.teamwork.project.model.Project

/**
 * @since 29/07/17.
 */
class ProjectListAdapter: RecyclerView.Adapter<ProjectListAdapter.ViewHolder> {
    private var items: List<Project>
    private var isTwoPane: Boolean
    private var fragmentManager: FragmentManager

    constructor(items: List<Project>, isTwoPane: Boolean, fragmentManager: FragmentManager) {
        this.items = items
        this.isTwoPane = isTwoPane
        this.fragmentManager = fragmentManager
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.project_list_content, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.item = items[position]
        holder.idView.setText(items[position].id)
        holder.contentView.setText(items[position].name)

        holder.mView.setOnClickListener({ v ->
//            if (isTwoPane) {
//                val arguments = Bundle()
//                arguments.putString(ProjectDetailFragment.ARG_ITEM_ID, holder.item!!.id)
//                val fragment = ProjectDetailFragment()
//                fragment.arguments = arguments
//                fragmentManager.beginTransaction()
//                        .replace(R.id.project_detail_container, fragment)
//                        .commit()
//            } else {
//                val context = v.context
//                val intent = Intent(context, ProjectDetailActivity::class.java)
//                intent.putExtra(ProjectDetailFragment.ARG_ITEM_ID, holder.item!!.id)
//
//                context.startActivity(intent)
//            }
        })
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val idView: TextView
        val contentView: TextView
        var item: Project? = null

        init {
            idView = mView.findViewById(R.id.id)
            contentView = mView.findViewById(R.id.content)
        }

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }
    }
}
