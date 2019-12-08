package kz.porcuon.movien.flow.reviews

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.vh_review.view.*
import kz.porcuon.domain.data.review.ReviewResponse
import kz.porcuon.movien.R
import kz.porcuon.movien.support.RVPageableAdapter
import kz.porcuon.movien.support.VHAbstract

class RVReviewsAdapter(
    private val context: Context,
    reviews: MutableList<ReviewResponse.Review>
) : RVPageableAdapter<ReviewResponse.Review>(reviews) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHAbstract<ReviewResponse.Review> {
        val view = LayoutInflater.from(context).inflate(R.layout.vh_review, parent, false)
        return VHReview(view)
    }

    class VHReview(itemView: View) : VHAbstract<ReviewResponse.Review>(itemView) {
        override fun bind(model: ReviewResponse.Review) = with(itemView) {
            tvAuthor.text = model.author
            tvContent.text = model.content
        }
    }
}