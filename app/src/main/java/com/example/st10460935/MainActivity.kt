package com.example.st10460935

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private val personList = mutableListOf<Person>()
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val history=findViewById<Button>(R.id.histoty)
        val clear=findViewById<Button>(R.id.clear)
        val name=findViewById<EditText>(R.id.name)
        val age =findViewById<EditText>(R.id.age)
        val result= findViewById<TextView>(R.id.result)
        val add=findViewById<Button>(R.id.add)

        history.setOnClickListener{



            if(age.text.toString().toInt()>= 20 && age.text.toString().toInt() <= 100){

                val findperson = personList.find { it.age==age.text.toString().toInt() }
                if(!findperson.toString().isNullOrEmpty()){

                  var results="you are ${age.text.toString()} years old,which is the same age as with ${name.text.toString()} ${name.text.toString()} was famous historical figure"
                    result.text=results

                }else{
                    result.text="there is no historical figure known to be around 20 years old"

                }



            }


        }
        clear.setOnClickListener{
            name.text.clear()
            age.text.clear()
        }
        add.setOnClickListener{


            if(name.text.toString().isNotEmpty() && age.text.toString().toInt()>=20 && age.text.toString().toInt()<=100){
                val  person = Person(name.text.toString(),age.text.toString().toInt())
                personList.add(person)

                 var res="record  for ${name.text.toString()}, age ${age.text.toString()}  added succefull"
                result.text=res
            }else{
                result.text="please enter valid name or age"
            }
        }
    }
}
data class Person(val name: String, val age:Int)