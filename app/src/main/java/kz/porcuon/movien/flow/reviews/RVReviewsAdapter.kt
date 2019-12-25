package kz.porcuon.movien.flow.reviews

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.vh_review.view.*
import kz.porcuon.domain.data.review.Review
import kz.porcuon.movien.R
import kz.porcuon.movien.support.RVPageableAdapter
import kz.porcuon.movien.support.VHAbstract

private const val MAX_LINES = Int.MAX_VALUE
private const val MIN_LINES = 3

class RVReviewsAdapter(
    private val context: Context,
    reviews: MutableList<Review>
) : RVPageableAdapter<Review>(reviews) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHAbstract<Review> {
        val view = LayoutInflater.from(context).inflate(R.layout.vh_review, parent, false)
        return VHReview(view)
    }

    class VHReview(itemView: View) : VHAbstract<Review>(itemView) {
        override fun bind(model: Review) = with(itemView) {
            tvAuthor.text = model.author
            tvContent.text = model.content
            tvShow.visibility = if (tvContent.lineCount > 3) View.GONE else View.VISIBLE
            tvShow.setOnClickListener {
                if (tvContent.maxLines == MAX_LINES) {
                    tvContent.maxLines = MIN_LINES
                    tvShow.text = context.getString(R.string.fragment_reviews_show_more)
                } else {
                    tvContent.maxLines = MAX_LINES
                    tvShow.text = context.getString(R.string.fragment_reviews_show_less)
                }
            }
        }
    }
}