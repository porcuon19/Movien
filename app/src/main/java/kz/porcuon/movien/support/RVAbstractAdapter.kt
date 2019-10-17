package kz.porcuon.movien.support

import androidx.recyclerview.widget.RecyclerView

abstract class RVAbstractAdapter<Model>(
    protected val items: MutableList<Model>
) : RecyclerView.Adapter<VHAbstract<Model>>() {

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: VHAbstract<Model>, position: Int) {
        holder.bind(items[position])
    }
}