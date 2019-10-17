package kz.porcuon.movien.support

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class VHAbstract<Model>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bind(model: Model)
}