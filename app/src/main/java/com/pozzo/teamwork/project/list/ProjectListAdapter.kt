package com.pozzo.teamwork.project.list

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.pozzo.teamwork.R
import com.pozzo.teamwork.project.model.Project
import com.squareup.picasso.Picasso

/**
 * @since 29/07/17.
 */
class ProjectListAdapter: RecyclerView.Adapter<ProjectListAdapter.ViewHolder> {
    private var items: List<Project>
    private var projectListView: ProjectListView

    constructor(items: List<Project>, projectListView: ProjectListView) {
        this.items = items
        this.projectListView = projectListView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_project_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.display(items[position])

        holder.view.setOnClickListener({ v ->
            projectListView.selectProject(holder.item)
        })
        holder.favoriteCheckBox.setOnClickListener { v ->
            Toast.makeText(v.context, "Not implemented yet", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val projectLogo: ImageView
        val contentView: TextView
        val favoriteCheckBox: View
        lateinit var item: Project

        init {
            projectLogo = view.findViewById(R.id.project_logo)
            contentView = view.findViewById(R.id.title)
            favoriteCheckBox = view.findViewById(R.id.favorite_check_box)
        }

        fun display(item: Project) {
            this.item = item
            contentView.text = item.name
            Picasso.with(view.context).
                    load(item.logo).
                    placeholder(R.drawable.project_icon).
                    into(projectLogo)
        }
    }
}
