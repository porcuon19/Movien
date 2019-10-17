package kz.porcuon.movien.support

abstract class RVPageableAdapter<Model>(
    items: MutableList<Model>
) : RVAbstractAdapter<Model>(items) {

    protected var isLoaderVisible = false

    fun addLoader() {
        isLoaderVisible = true
        items.add(items[items.size - 1])
        notifyItemInserted(items.size - 1)
    }

    fun removeLoader() {
        isLoaderVisible = false
        items.removeAt(items.size - 1)
        notifyItemRemoved(items.size)
    }

    fun addItems(items: MutableList<Model>) {
        this.items.addAll(items)
        notifyItemRangeInserted(this.items.size - items.size, items.size)
    }
}