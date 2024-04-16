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
            val age=age.text.toString().toInt()
            if(age>= 20 && age <= 100){
                val findperson = personList.find { it.age==age }

                result.text= "age for $findperson.name  is $findperson.age"
            }else{
                result.text="we don't have that person"

            }


        }
        clear.setOnClickListener{
            name.text.clear()
            age.text.clear()
        }
        add.setOnClickListener{
            val  name=name.text.toString()
            val age=age.text.toString().toInt()
            if(name.isNotEmpty() && age>=20 && age<=100){
                val  person = Person(name,age)
                personList.add(person)

                result.text="record $name,$age  added succefull"
            }else{
                result.text="please enter valid name or age"
            }
        }
    }
}
data class Person(val name: String, val age:Int)