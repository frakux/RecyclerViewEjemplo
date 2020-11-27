package com.example.recyclerviewejercicio

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recyclerviewejercicio.base.BaseViewHolder
import com.example.recyclerviewejercicio.modelo.Animal
import kotlinx.android.synthetic.main.animales_row.view.*
import java.lang.IllegalArgumentException


class RecyclerAdapter
    (private val context: Context,
     private val listaAnimales: List<Animal>,
     private val itemClickListener: OnAnimalClickListener
) : RecyclerView.Adapter<BaseViewHolder<*>>() {

    interface OnAnimalClickListener{
        fun onImageClick(imagen: String)
        fun onItemClick(nombre: String)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return AnimalesViewHolder(
            LayoutInflater.from(context).inflate(R.layout.animales_row, parent, false)
        )
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when (holder) {
            is AnimalesViewHolder -> holder.bind(listaAnimales[position], position)
            else -> throw IllegalArgumentException("Se Olvido pasar ViewHolder en el Bind")
        }
    }

    override fun getItemCount(): Int {
        return listaAnimales.size
    }

    inner class AnimalesViewHolder(itemView: View) : BaseViewHolder<Animal>(itemView) {
        override fun bind(item: Animal, position: Int) {
            itemView.setOnClickListener{itemClickListener.onItemClick(item.nombre)}
            itemView.img_animal.setOnClickListener { itemClickListener.onImageClick(item.imagen) }
            Glide.with(context).load(item.imagen).into(itemView.img_animal)
            itemView.txt_nombre_animal.text = item.nombre
            itemView.numero.text=item.rating
        }
    }
}