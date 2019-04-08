package com.maideveloper.kotlinsqlite

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        try {

            var myDatabase=this.openOrCreateDatabase("Musicians", Context.MODE_PRIVATE,null)

            //Creating/Open Database Table
            myDatabase.execSQL("CREATE TABLE IF NOT EXISTS musicians (name VARCHAR,age INT(2))")

            //Inserting values
//            myDatabase.execSQL("INSERT INTO musicians(name,age) Values ('James',30)")
//            myDatabase.execSQL("Insert into musicians (name,age) Values ('Ali',23)")
//            myDatabase.execSQL("insert into musicians (name,age) values('Bob',56)")
//            myDatabase.execSQL("insert into musicians (name,age) values('Harry',46)")
//            myDatabase.execSQL("insert into musicians (name,age) values('Bat',20)")




            //Retrieving Data
            val cursor=myDatabase.rawQuery("Select * from musicians where name='Ali' or name Like '%b%'",null)
            val nameIndex=cursor.getColumnIndex("name")
            val ageIndex=cursor.getColumnIndex("age")

//            //updating value
//            myDatabase.execSQL("update musicians set age=17 where name='Bat'")
//
//            //Delete value
//            myDatabase.execSQL("Delete from musicians ")


            cursor.moveToFirst()
            while (cursor!=null){
                println("Name : "+cursor.getString(nameIndex))
                println("Age : "+cursor.getString(ageIndex))
                cursor.moveToNext()

            }
            if(cursor!=null){
                cursor!!.close()
            }



        }catch (e:Exception){
            e.printStackTrace()
        }

    }
}
