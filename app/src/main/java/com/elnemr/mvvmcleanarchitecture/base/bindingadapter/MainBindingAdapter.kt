package com.elnemr.mvvmcleanarchitecture.base.bindingadapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import coil.load
import com.elnemr.mvvmcleanarchitecture.R
import org.jsoup.Jsoup

class MainBindingAdapter {
    companion object {
        @BindingAdapter("setNoneStringText")
        @JvmStatic
        fun setNoneStringText(textView: TextView, text: Any) {
            textView.text = text.toString()
        }

        @BindingAdapter("loadImage")
        @JvmStatic
        fun loadImage(imageView: ImageView, url: String) {
            // using coil image loader library
            imageView.load(url) {
                crossfade(600)
                error(R.drawable.ic_launcher_background)
                placeholder(R.drawable.ic_launcher_foreground)
            }
        }

        @BindingAdapter("toggleVisibility")
        @JvmStatic
        fun toggleVisibility(view: View, isVisible: Boolean) {
            if (isVisible){
                view.visibility = View.VISIBLE
            }else{
                view.visibility = View.GONE
            }
        }

        @BindingAdapter("parseHtml")
        @JvmStatic
        fun parseHtml(textView: TextView, text: String?) {
            if (text != null) {
                val txt = Jsoup.parse(text).text()
                textView.text = txt
            }

        }

    }

}