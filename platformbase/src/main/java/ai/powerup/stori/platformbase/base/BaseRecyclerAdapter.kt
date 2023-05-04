package ai.powerup.stori.platformbase.base

import ai.powerup.stori.platformbase.common.extensions.action
import ai.powerup.stori.platformbase.common.extensions.snack
import ai.powerup.stori.platformbase.common.recycler.SwipeRemoveActionCallback
import ai.powerup.stori.platformbase.common.recycler.SwipeRemoveItemDecoration
import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.view.View
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

abstract class BaseRecyclerAdapter<T: Any>(
    private val masterList: MutableList<T> =  mutableListOf(),
    private val swipeDelegate: SwipeActionDelegate? = null
): RecyclerView.Adapter<RecyclerView.ViewHolder>(), SwipeRemoveActionCallback.SwipeRemoveActionListener {

    private lateinit var swipeItemTouchHelper: ItemTouchHelper

    private var recentlyDeleted = HashSet<T>()

    override fun getItemCount(): Int = masterList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) =
        (holder as BaseViewHolder<T>).onBind(data = masterList[position], position = position)

    abstract class BaseViewHolder<E>(internal val view: View): RecyclerView.ViewHolder(view) {
        abstract fun onBind(data: E, position: Int)
    }

    protected fun getItemAtPosition(position: Int): T = masterList[position]

    protected fun getItems(): MutableList<T> = masterList

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(list: List<T>) {
        masterList.clear()
        masterList.addAll(elements = list)
        notifyDataSetChanged()
    }

    private fun deleteItemSwipe(position: Int) {
        notifyItemRemoved(position)
        recentlyDeleted.add(element = masterList[position])
        masterList.removeAt(position)
    }

    private fun undoDeleteSingle(item: T, position: Int, action: (() -> Unit)?) {
        masterList.add(index = position, element = item)
        recentlyDeleted.clear()
        notifyItemInserted(position)
        action?.invoke()
    }

    fun showUndoSnackbar(
        view: View,
        item: T,
        position: Int = 0,
        message: String,
        actionTitle: String,
        undoAction: (() -> Unit)? =  null
    ) {
        view.snack(message = message, length = Snackbar.LENGTH_LONG) {
            action(actionTitle = actionTitle) {
                undoDeleteSingle(item = item, position = position, action = undoAction)
            }
        }
    }

    override fun removeItem(position: Int) {
        val item = getItemAtPosition(position = position)
        deleteItemSwipe(position = position)
        swipeDelegate?.swipeDelete(item = item, position = position)
    }

    /**
     * If no swipe is required the returned value should be "ItemTouchHelper.ACTION_STATE_IDLE"
     */
    abstract fun viewHolderSwipeBehavior(viewHolder: RecyclerView.ViewHolder): Int

    override fun swipeBehavior(viewHolder: RecyclerView.ViewHolder): Int =
        viewHolderSwipeBehavior(viewHolder = viewHolder)

    fun swipeSettings(
        context: Context,
        recyclerView: RecyclerView,
        @ColorRes backgroundColor: Int = com.google.android.material.R.color.design_default_color_background,
        @DrawableRes iconRes: Int = com.airbnb.lottie.R.drawable.abc_ab_share_pack_mtrl_alpha,
        withAnimation: Boolean = false
    ) {
        val background = ColorDrawable(ContextCompat.getColor(context, backgroundColor))
        val icon = ContextCompat.getDrawable(context, iconRes)
        if (withAnimation) recyclerView.addItemDecoration(SwipeRemoveItemDecoration(background, icon))
        swipeItemTouchHelper = ItemTouchHelper(
            SwipeRemoveActionCallback(
                background,
                icon,
                hashSetOf(this)
            )
        )
        swipeItemTouchHelper.attachToRecyclerView(recyclerView)
    }

    interface SwipeActionDelegate {
        fun <T: Any> swipeDelete(item: T, position: Int)
    }
}