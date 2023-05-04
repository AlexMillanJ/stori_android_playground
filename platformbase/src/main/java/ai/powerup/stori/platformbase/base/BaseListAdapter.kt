package ai.powerup.stori.platformbase.base

import ai.powerup.stori.platformbase.common.utils.DiffUtilCallback
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseListAdapter<T: Any, VB: ViewBinding>(
    private val inflateMethod: (LayoutInflater, ViewGroup?, Boolean) -> VB
): ListAdapter<T, BaseListAdapter<T, VB>.BaseListViewHolder>(DiffUtilCallback()) {

    private var _binding: VB? = null
    protected val binding: VB get() = _binding!!

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewTYpe: Int): BaseListViewHolder {
        _binding = inflateMethod.invoke(
            LayoutInflater.from(viewGroup.context),
            viewGroup,
            false
        )
        return BaseListViewHolder(_binding!!.root)
    }

    override fun onBindViewHolder(viewHolder: BaseListViewHolder, position: Int) =
        viewHolder.bind(getItem(position))

    inner class BaseListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        internal fun bind(internalItem: T){
            bindView(item = internalItem)
        }
    }

    protected abstract fun bindView(item: T)

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        super.onDetachedFromRecyclerView(recyclerView)
        _binding = null
    }
}