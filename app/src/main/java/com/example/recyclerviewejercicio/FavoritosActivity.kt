package com.example.recyclerviewejercicio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewejercicio.modelo.Animal
import kotlinx.android.synthetic.main.activity_main.*

class FavoritosActivity : AppCompatActivity(),RecyclerAdapter.OnAnimalClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favoritos)
        MyToolbar().show(this,"Favoritos",true)

        setupRecyclerView()
        val kToolbar : Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(kToolbar)
    }


    private fun setupRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        val listAnimales: List<Animal> = listOf(
                Animal ("Nemo","https://www.yucatan.com.mx/wp-content/uploads/2019/11/images-3-18.jpg","8"),
                Animal ("Nevo","https://s1.eestatic.com/2020/08/06/actualidad/Actualidad_510959894_157148069_1024x576.jpg","6"),
                Animal(
                        "Coffi",
                        "https://www.hola.com/imagenes/estar-bien/20190426141097/cerebro-perros-memoria-cs/0-672-261/cerebroperro-t.jpg?filter=w600&filter=ds75","5"

                ),
                Animal(
                        "Manchas",
                        "https://www.infobae.com/new-resizer/oWZXB8xLLNfiTgqgTJ49AfA5cFk=/420x236/filters:format(jpg):quality(85)//arc-anglerfish-arc2-prod-infobae.s3.amazonaws.com/public/3KJ4AFYLUZAG7DYO7IJULMZ3P4.jpg","3"
                ),
                Animal(
                        "Tigre",
                        "https://www.purina-latam.com/sites/g/files/auxxlc391/files/styles/facebook_share/public/purina-7-razas-de-perros-peque%C3%B1os-para-departamento.png?itok=zbagBgZK","3"
                )

        )
        recyclerView.adapter = RecyclerAdapter(this,listAnimales,this)

    }
    override fun onImageClick(imagen: String) {
        val intent = Intent (this,ImageDetail::class.java)
        intent.putExtra("imageUrl",imagen)
        startActivity(intent)
    }

    override fun onItemClick(nombre: String) {
        Toast.makeText(this,"La Mascota es : $nombre", Toast.LENGTH_SHORT).show()
    }
}