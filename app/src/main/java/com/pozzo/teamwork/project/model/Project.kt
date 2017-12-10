package com.pozzo.teamwork.project.model

import android.os.Parcel
import android.os.Parcelable

/**
 * Represent a project inside Teamwork.
 * A Site may contains multiples projects.
 *
 * @see com.pozzo.teamwork.architecture.model.Site
 * @since 27/07/17.
 */
data class Project(val id: String, val logo: String?, val name: String, val description: String,
                   val isProjectAdmin: Boolean) : Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readByte() != 0.toByte())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(logo)
        parcel.writeString(name)
        parcel.writeString(description)
        parcel.writeByte(if (isProjectAdmin) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Project> {
        override fun createFromParcel(parcel: Parcel): Project {
            return Project(parcel)
        }

        override fun newArray(size: Int): Array<Project?> {
            return arrayOfNulls(size)
        }
    }
}
