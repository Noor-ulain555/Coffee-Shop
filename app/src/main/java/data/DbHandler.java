package data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

import Models.Ordermodel;

public class DbHandler extends SQLiteOpenHelper {
 final static   String DBName="myDataBase.db";
 final static int DBVersion=4;
    public DbHandler(@Nullable Context context) {
        super(context, DBName,null,DBVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
       db.execSQL(" create table orders"+
               "(id integer primary key autoincrement," +
               "name text," +
               "phone text," +
               "image int," +
               "price int," +
               "description text," +
               "foodName text," +
               "quantity int)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //table drop here and new table create for previous position
    db.execSQL("drop table if exists orders ");
    //new table create with new name
        onCreate(db);
    }

    public boolean InsertOrder(String name, String phone,int image,int price , String description,
                               String foodName,int quantity){
            SQLiteDatabase database=getReadableDatabase();
        ContentValues values=new ContentValues();
        /*
        * 0 =id
        * 1=name
        * 2=phone
        * 3=image
        * 4=price
        * 5=description
        * 6=foodname
        * 7=quantity
        * */
        values.put("name",name);
        values.put("phone",phone);
        values.put("image",image);
        values.put("price",price);
        values.put("description",description);
        values.put("foodname",foodName);
        values.put("quantity",quantity);

        long id=database.insert("orders",null,values);
        if(id<=0){

            return false;
        }else {
            return true;
        }
    }
    public ArrayList<Ordermodel> getOrders(){
        ArrayList<Ordermodel> orders=new ArrayList<>();
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor= db.rawQuery("select id,foodname,image,price from orders",null);
        if (cursor.moveToFirst()) {
            do {
                Ordermodel ordermodel = new Ordermodel();
                ordermodel.setOrderNumber(cursor.getInt(0) + "");
                ordermodel.setSoldItemName(cursor.getString(1));
                ordermodel.setOrderImage(cursor.getInt(2));
                ordermodel.setPrice(cursor.getInt(3));
                orders.add(ordermodel);
            } while (cursor.moveToNext());
        }

            cursor.close();
        db.close();
        return orders;
    }
    public Cursor getOrderById(int id){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor= db.rawQuery(" select * from orders where id =  "+id,null);

     if(cursor!=null){
         cursor.moveToFirst();
     }
        return cursor;
    }
    public boolean UpdateOrder(String name, String phone,int image,String price , String description,
                               String foodName,int quantity,int id){
        SQLiteDatabase database=getReadableDatabase();
        ContentValues values=new ContentValues();
        /*
         * 0 =id
         * 1=name
         * 2=phone
         * 3=image
         * 4=price
         * 5=description
         * 6=foodname
         * 7=quantity
         * */
        values.put("name",name);
        values.put("phone",phone);
        values.put("image",image);
        values.put("price",price);
        values.put("description",description);
        values.put("foodname",foodName);
        values.put("quantity",quantity);

        long row=database.update("orders",values,"id="+id,null);
        if(row<=0){
            return false;
        }else {
            return true;
        }
    }
    public int deleteOrder(String id){
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete("orders","id="+id,null);
    }
}
