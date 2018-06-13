package co.neprass.managefarm;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by AL-Qema on 02/06/18.
 */

public class SQLDatabase extends SQLiteOpenHelper {


    // Database Name

    private static final String DATABASE_NAME = "Farm.db";


    // Table Names

    private static final String CAGR_CROP_ITEM_CLASS = "CAGR_CROP_ITEM_CLASS";//تصنيف الأصناف الزراعية حسب النوع المحصول
    private static final String CAGR_CROP_ITEM = "CAGR_CROP_ITEM";
    private static final String CAGR_LESION = "CAGR_LESION";// الافات الزراعية
    private static final String BENEFICIARY = "BENEFICIARY"; // بيانات المستفيد
    private static final String AGR_TEMP_WORKER = "AGR_TEMP_WORKER"; /// القوى العاملة
    private static final String C_SOCIAL_STATUS = "C_SOCIAL_STATUS";//الحالة الاجتماعية
    private static final String C_QUALIFICATION = "C_QUALIFICATION";//المؤهل العلمي
    private static final String C_CITY = "C_CITY";//ا
    private static final String C_SECTOR = "C_SECTOR";//ا
    private static final String AGR_WORKER = "AGR_WORKER";//ا
    private static final String AGR_GUIDE = "AGR_GUIDE";//ا
    private static final String C_TYPE_BUILDING = "C_TYPE_BUILDING";//ا
    private static final String C_OWNER_BUILDING = "C_OWNER_BUILDING";//ا
    private static final String AGR_BUILDING = "AGR_BUILDING";//ا
    private static final String C_TYPE_FARM = "C_TYPE_FARM";//ا
    private static final String C_TYPE_ROOF_FARM = "C_TYPE_ROOF_FARM";//ا

    private static final String AGR_INSTRUMENT = "AGR_INSTRUMENT";//ا
    private static final String C_OWNER_INSTRUMENT = "C_OWNER_INSTRUMENT";//ا
    private static final String C_TYPE_INSTRUMENT = "C_TYPE_INSTRUMENT";//ا
    private static final String AGR_LAND = "AGR_LAND";//ا
    private static final String AGR_FARMER = "AGR_FARMER";//ا
    private static final String AGR_CHICKEN = "AGR_CHICKEN";//ا
    private static final String AGR_PARTNER = "AGR_PARTNER";//ا
    private static final String AGR_ANIMAL_PRODUCTION = "AGR_ANIMAL_PRODUCTION";//ا
    private static final String CAGP_ANIMAL_ITEM = "AGR_ANIMAL_ITEM";//ا
    private static final String CAGP_ANIMAL_AGE = "CAGP_ANIMAL_AGE";//ا
    private static final String AGP_OTHER = "AGP_OTHER";//ا
    private static final String CAGP_OTHER_ITEM = "CAGP_OTHER_ITEM";//ا
    private static final String AGP_IRRIGATION = "AGP_IRRIGATION";//ا
    private static final String C_APPLICATION_IRRIGATION = "C_APPLICATION_IRRIGATION";//ا
    private static final String AGP_BEE = "AGP_BEE";//ا
    private static final String CAGP_BEE_ITEM = "CAGP_BEE_ITEM";//ا

    private static final String AGP_PLANT_AREA = "AGP_PLANT_AREA";//ا



    private static final String ITEM_SID = "ITEM_SID";
    private static final String CROP_TYPE = "CROP_TYPE";
    private static final String ITEM_CLASS_SID = "ITEM_CLASS_SID";


    private static final String LESION_SID = "LESION_SID";
    private static final String CROP_ITEM_NAME = "CROP_ITEM_NAME";
    private static final String CROP_ITEM_ACTIVE = "CROP_ITEM_ACTIVE";
    private static final String CONS_AVG = "CONS_AVG";

    private static final String CROP_ITEM_SID = "CROP_ITEM_SID";
    private static final String LESION_DESC = "LESION_DESC";
    private static final String LESION_ACTIVE = "LESION_ACTIVE";

    private static final String BENF_SID = "BENF_SID";
    private static final String BENF_ID = "BENF_ID";
    private static final String BENF_NAME1 = "BENF_NAME1";
    private static final String BENF_NAME2 = "BENF_NAME2";
    private static final String BENF_NAME3 = "BENF_NAME3";
    private static final String BENF_NAME4 = "BENF_NAME4";
    private static final String BENF_SEX = "BENF_SEX";
    private static final String BENF_ADDRESS = "BENF_ADDRESS";
    private static final String BENF_MOBILE_NO = "BENF_MOBILE_NO";
    private static final String BENF_TEL_NO = "BENF_TEL_NO";
    private static final String BENF_DOB = "BENF_DOB";
    private static final String BENF_EMAIL = "BENF_EMAIL";


    private static final String FARMER_SID = "FARMER_SID";
    private static final String WORKER_MALE = "WORKER_MALE";
    private static final String WORKER_MALE_FAMILY = "WORKER_MALE_FAMILY";
    private static final String WORKER_FEMALE = "WORKER_FEMALE";
    private static final String WORKER_FEMALE_FAMILY = "WORKER_FEMALE_FAMILY";

    private static final String SOCIAL_STATUS_SID = "SOCIAL_STATUS_SID";
    private static final String SOCIAL_STATUS_TITLE = "SOCIAL_STATUS_TITLE";
    private static final String SOCIAL_ACTIVE = "SOCIAL_ACTIVE";

    private static final String QUALIFICATION_SID = "QUALIFICATION_SID";
    private static final String QUALIFICATION_TITLE = "QUALIFICATION_TITLE";
    private static final String QUALIFICATION_ACTIVE = "QUALIFICATION_ACTIVE";

    private static final String WORKER_SID = "WORKER_SID";
    private static final String WORKER_ID = "WORKER_ID";
    private static final String WORKER_NAME = "WORKER_NAME";
    private static final String WORKER_SEX = "WORKER_SEX";
    private static final String WORKER_MOBILE_NO = "WORKER_MOBILE_NO";
    private static final String WORKER_ADDRESS = "WORKER_ADDRESS";
    private static final String WORKER_IS_FAMILY = "WORKER_IS_FAMILY";
    private static final String WORKER_DEL = "WORKER_DEL";

    private static final String FARMER_CARD_NO = "FARMER_CARD_NO";
    private static final String FARMER_DEL = "FARMER_DEL";
    private static final String FARMER_ARCHIVE = "FARMER_ARCHIVE";
    private static final String INSERT_DATE = "INSERT_DATE";

    private static final String CITY_SID = "CITY_SID";
    private static final String CITY_Name = "CITY_Name";
    private static final String CITY_ACTIVE = "CITY_ACTIVE";

    private static final String SECTOR_SID = "SECTOR_SID";
    private static final String SECTOR_Name = "SECTOR_Name";

    private static final String GUIDE_SID = "GUIDE_SID";
    private static final String GUIDE_NOTE = "GUIDE_NOTE";
    private static final String GUIDE_TYPE = "GUIDE_TYPE";

    private static final String LAND_SID = "LAND_SID";
    private static final String LAND_PIECE_NO = "LAND_PIECE_NO";
    private static final String LAND_SECTOR_NO = "LAND_SECTOR_NO";
    private static final String LAND_LOC_LONG = "LAND_LOC_LONG";
    private static final String LAND_LOC_LAT = "LAND_LOC_LAT";
    private static final String LAND_BUILDING_AREA = "LAND_BUILDING_AREA";
    private static final String LAND_UN_BUILDING_AREA = "LAND_UN_BUILDING_AREA";
    private static final String LAND_UNUSED_PERMANENT_AREA = "LAND_UNUSED_PERMANENT_AREA";
    private static final String LAND_UNUSED_TEMP_AREA = "LAND_UNUSED_TEMP_AREA";
    private static final String LAND_PLANTED_AREA = "LAND_PLANTED_AREA";
    private static final String LAND_TREE_AREA = "LAND_TREE_AREA";
    private static final String LAND_TOTAL_AREA = "LAND_TOTAL_AREA";
    private static final String LAND_DISTANCE = "LAND_DISTANCE";
    private static final String LAND_NOTES = "LAND_NOTES";
    private static final String LAND_OWNERSHIP_TYPE = "LAND_OWNERSHIP_TYPE";
    private static final String LAND_OWNER_TYPE = "LAND_OWNER_TYPE";
    private static final String LAND_OWNER_BENF_SID = "LAND_OWNER_BENF_SID";
    private static final String LAND_ORG_TYPE = "LAND_ORG_TYPE";
    private static final String NEAREST_LOCATION = "NEAREST_LOCATION"; //أقرب معلم

    private static final String BUILD_SID = "BUILD_SID";
    private static final String BUILD_TYPE = "BUILD_TYPE";
    private static final String BUILD_AREA = "BUILD_AREA";
    private static final String BUILD_OWNER_TYPE = "BUILD_OWNER_TYPE";
    private static final String FARM_TYPE = "FARM_TYPE";
    private static final String FARM_ROOF_TYPE = "FARM_ROOF_TYPE";
    private static final String BUILD_DEL = "BUILD_DEL";

    private static final String CHICKEN_SID = "CHICKEN_SID";
    private static final String CHICKEN_TYPE = "CHICKEN_TYPE";
    private static final String CHICKEN_COUNT = "CHICKEN_COUNT";
    private static final String CHICKEN_AGE_DAY = "CHICKEN_AGE_DAY";
    private static final String CHICKEN_AGE_MONTH = "CHICKEN_AGE_MONTH";
    private static final String CHICKEN_NOTE = "CHICKEN_NOTE";
    private static final String CHICKEN_DEL = "CHICKEN_DEL";

    private static final String INST_OWNER_SID = "INST_OWNER_SID";
    private static final String INST_OWNER_TITLE = "INST_OWNER_TITLE";
    private static final String INST_OWNER_ACTIVE = "INST_OWNER_ACTIVE";

    private static final String INST_TYPE_SID = "INST_TYPE_SID";
    private static final String INST_TYPE_TITLE = "INST_TYPE_TITLE";
    private static final String INST_TYPE_ACTIVE = "INST_TYPE_ACTIVE";

    private static final String INST_SID = "INST_SID";
    private static final String INST_COUNT = "INST_COUNT";
    private static final String INST_NOTES = "INST_NOTES";
    private static final String INST_DEL = "INST_DEL";

    private static final String TYPE_BUILDING_SID = "TYPE_BUILDING_SID";
    private static final String TYPE_BUILDING_TITLE = "TYPE_BUILDING_TITLE";
    private static final String TYPE_BUILDING_ACTIVE = "TYPE_BUILDING_ACTIVE";

    private static final String OWNER_BUILDING_SID = "OWNER_BUILDING_SID";
    private static final String OWNER_BUILDING_TITLE = "OWNER_BUILDING_TITLE";
    private static final String OWNER_BUILDING_ACTIVE = "OWNER_BUILDING_ACTIVE";

    private static final String TYPE_FARM_SID = "TYPE_FARM_SID";
    private static final String TYPE_FARM_TITLE = "TYPE_FARM_TITLE";
    private static final String TYPE_FARM_ACTIVE = "TYPE_FARM_ACTIVE";

    private static final String TYPE_ROOF_FARM_SID = "TYPE_ROOF_FARM_SID";
    private static final String TYPE_ROOF_FARM_TITLE = "TYPE_ROOF_FARM_TITLE";
    private static final String TYPE_ROOF_FARM_ACTIVE = "TYPE_ROOF_FARM_ACTIVE";

    private static final String APPLICATION_IRR_SID = "APPLICATION_IRR_SID";
    private static final String APPLICATION_IRR_NAME = "APPLICATION_IRR_NAME";
    private static final String APPLICATION_IRR_ACTIVE = "APPLICATION_IRR_ACTIVE";


    public SQLDatabase(Context context) {


        super(context, DATABASE_NAME, null, 2);

    }


    @Override

    public void onCreate(SQLiteDatabase db) {

        // Table Create  teacher

        db.execSQL("CREATE TABLE " + CAGR_CROP_ITEM_CLASS + " ( " + ITEM_SID + " INTEGER PRIMARY KEY AUTOINCREMENT" +

                "," + CROP_TYPE + " TEXT  ," + ITEM_CLASS_SID + " TEXT);");

        db.execSQL("CREATE TABLE " + CAGR_CROP_ITEM + " ( " + CROP_ITEM_SID + " INTEGER PRIMARY KEY AUTOINCREMENT" +
                "," + CROP_TYPE + " TEXT  ," + CROP_ITEM_NAME + " TEXT ," + CROP_ITEM_ACTIVE + " INTEGER , " + CONS_AVG + " INTEGER ,  " +
                ITEM_CLASS_SID + " INTEGER ,  " +
                " FOREIGN KEY (" + ITEM_CLASS_SID + ") REFERENCES " + CAGR_CROP_ITEM_CLASS + " (" + ITEM_CLASS_SID + "));");


        db.execSQL("CREATE TABLE " + CAGR_LESION + " ( " + LESION_SID + " INTEGER PRIMARY KEY AUTOINCREMENT" +

                "," + LESION_DESC + " TEXT  UNIQUE," + LESION_ACTIVE + " INTEGER);");

        db.execSQL("CREATE TABLE " + AGR_TEMP_WORKER + " ( " + FARMER_SID + " INTEGER PRIMARY KEY AUTOINCREMENT" +

                "," + WORKER_MALE + "   INTEGER," + WORKER_MALE_FAMILY + " INTEGER ," + WORKER_FEMALE + " INTEGER  ," + WORKER_FEMALE_FAMILY + " INTEGER);");

        db.execSQL("CREATE TABLE " + C_SOCIAL_STATUS + " ( " + SOCIAL_STATUS_SID + " INTEGER PRIMARY KEY AUTOINCREMENT" +

                "," + SOCIAL_STATUS_TITLE + "   TEXT  UNIQUE," + SOCIAL_ACTIVE + " INTEGER );");

        db.execSQL("CREATE TABLE " + C_QUALIFICATION + " ( " + QUALIFICATION_SID + " INTEGER PRIMARY KEY AUTOINCREMENT" +

                "," + QUALIFICATION_TITLE + "   TEXT  UNIQUE," + QUALIFICATION_ACTIVE + " INTEGER );");

        db.execSQL("CREATE TABLE " + BENEFICIARY + " ( " + BENF_SID + " INTEGER PRIMARY KEY AUTOINCREMENT" +

                "," + BENF_ID + " TEXT  ," + BENF_NAME1 + " TEXT  ," + BENF_NAME2 + " TEXT  ," + BENF_NAME3 + " TEXT  ," + BENF_NAME4 +
                " TEXT ," + BENF_SEX + " TEXT ," + BENF_ADDRESS + " TEXT ," + BENF_MOBILE_NO + " TEXT ," +
                BENF_EMAIL + " TEXT ," + BENF_TEL_NO + " TEXT ," +CITY_SID + " INTEGER ," + SECTOR_SID + " INTEGER ," +
                QUALIFICATION_SID + " INTEGER ," +SOCIAL_STATUS_SID + " INTEGER ," +
                "FOREIGN KEY (" + CITY_SID + ") REFERENCES " + C_CITY + " (" + CITY_SID + ") , " +
                "FOREIGN KEY (" + SECTOR_SID + ") REFERENCES " + C_SECTOR + " (" + SECTOR_SID + ")," +
                "FOREIGN KEY (" + QUALIFICATION_SID + ") REFERENCES " + C_QUALIFICATION + " (" + QUALIFICATION_SID + ") ," +
                "FOREIGN KEY (" + SOCIAL_STATUS_SID + ") REFERENCES " + C_SOCIAL_STATUS + " (" + SOCIAL_STATUS_SID + "));");


        db.execSQL("CREATE TABLE " + C_CITY + " ( " + CITY_SID + " INTEGER PRIMARY KEY AUTOINCREMENT" +

                "," + CITY_Name + "   TEXT  UNIQUE," + CITY_ACTIVE + " INTEGER );");

        db.execSQL("CREATE TABLE " + C_SECTOR + " ( " + SECTOR_SID + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                CITY_SID + " INTEGER "+
                "," + SECTOR_Name + "   TEXT  UNIQUE, FOREIGN KEY (" + CITY_SID + ") REFERENCES " + C_CITY + " (" + CITY_SID + ") );");

        db.execSQL("CREATE TABLE " + AGR_FARMER + " ( " + FARMER_SID + " INTEGER PRIMARY KEY AUTOINCREMENT" +
                "," + FARMER_CARD_NO + " INTEGER  ," + FARMER_DEL + " INTEGER ," + FARMER_ARCHIVE + " INTEGER , " +
                BENF_SID + " INTEGER ,"+
                " FOREIGN KEY (" + BENF_SID + ") REFERENCES " + BENEFICIARY + " (" + BENF_SID + "));");

        db.execSQL("CREATE TABLE " + AGR_WORKER + " ( " + WORKER_SID + " INTEGER PRIMARY KEY AUTOINCREMENT" +
                "," + WORKER_ID + " INTEGER  ," + WORKER_NAME + " TEXT ," + WORKER_SEX + " TEXT , " + WORKER_MOBILE_NO + " TEXT ," +
                WORKER_ADDRESS + " TEXT , " + WORKER_IS_FAMILY + " INTEGER, " + WORKER_DEL + " INTEGER, " +
                BENF_SID + " INTEGER ,"+
                " FOREIGN KEY (" + BENF_SID + ") REFERENCES " + BENEFICIARY + " (" + BENF_SID + "));");


        db.execSQL("CREATE TABLE " + AGR_GUIDE + " ( " + GUIDE_SID + " INTEGER PRIMARY KEY AUTOINCREMENT" +
                "," + GUIDE_TYPE + " TEXT  ," + GUIDE_NOTE + " TEXT," +
                CITY_SID + " INTEGER ,"+ SECTOR_SID + " INTEGER ,"+
                "FOREIGN KEY (" + CITY_SID + ") REFERENCES " + C_CITY + " (" + CITY_SID + ") , " +
                "FOREIGN KEY (" + SECTOR_SID + ") REFERENCES " + C_SECTOR + " (" + SECTOR_SID + "));");

        db.execSQL("CREATE TABLE " + AGR_LAND + " ( " + LAND_SID + " INTEGER PRIMARY KEY AUTOINCREMENT" +
                "," + LAND_PIECE_NO + " TEXT  ," + LAND_SECTOR_NO + " TEXT  ," + LAND_BUILDING_AREA + " TEXT  ," +
                LAND_UN_BUILDING_AREA + " INTEGER ," + LAND_UNUSED_PERMANENT_AREA + " INTEGER ," + LAND_UNUSED_TEMP_AREA + " INTEGER ," +
                LAND_PLANTED_AREA + " INTEGER ," + LAND_TREE_AREA + " INTEGER ," + LAND_TOTAL_AREA + " INTEGER , " + LAND_DISTANCE + " INTEGER ," +
                LAND_NOTES + " TEXT , " + LAND_OWNERSHIP_TYPE + " INTEGER , " + LAND_OWNER_TYPE + " INTEGER ," +
                LAND_OWNER_BENF_SID + " INTEGER , " + LAND_ORG_TYPE + " INTEGER , " + NEAREST_LOCATION + " INTEGER , " +
                FARMER_SID + " INTEGER , " + CITY_SID + " INTEGER , " + SECTOR_SID + " INTEGER , " +
                "FOREIGN KEY (" + FARMER_SID + ") REFERENCES " + AGR_FARMER + " (" + FARMER_SID + ") , " +
                "FOREIGN KEY (" + CITY_SID + ") REFERENCES " + C_CITY + " (" + CITY_SID + ") , " +
                "FOREIGN KEY (" + SECTOR_SID + ") REFERENCES " + C_SECTOR + " (" + SECTOR_SID + "));");

        db.execSQL("CREATE TABLE " + AGR_BUILDING + " ( " + BUILD_SID + " INTEGER PRIMARY KEY AUTOINCREMENT" +
                "," + BUILD_TYPE + " INTEGER  ," + BUILD_AREA + " INTEGER," + BUILD_OWNER_TYPE + " INTEGER," +
                FARM_TYPE + " INTEGER," + FARM_ROOF_TYPE + " INTEGER," + BUILD_DEL + " INTEGER," +
                LAND_SID + " INTEGER , " +
                "FOREIGN KEY (" + LAND_SID + ") REFERENCES " + AGR_LAND + " (" + LAND_SID + "));");

        db.execSQL("CREATE TABLE " + AGR_CHICKEN + " ( " + CHICKEN_SID + " INTEGER PRIMARY KEY AUTOINCREMENT" +
                "," + CHICKEN_TYPE + " INTEGER  ," + CHICKEN_COUNT + " INTEGER," + CHICKEN_AGE_DAY + " INTEGER," +
                CHICKEN_AGE_MONTH + " INTEGER," + CHICKEN_NOTE + " TEXT," + CHICKEN_DEL + " INTEGER," +
                LAND_SID + " INTEGER , " +
                "FOREIGN KEY (" + LAND_SID + ") REFERENCES " + AGR_LAND + " (" + LAND_SID + "));");

        db.execSQL("CREATE TABLE " + C_OWNER_INSTRUMENT + " ( " + INST_OWNER_SID + " INTEGER PRIMARY KEY AUTOINCREMENT" +

                "," + INST_OWNER_TITLE + "   TEXT  UNIQUE," + INST_OWNER_ACTIVE + " INTEGER );");

        db.execSQL("CREATE TABLE " + C_TYPE_INSTRUMENT + " ( " + INST_TYPE_SID + " INTEGER PRIMARY KEY AUTOINCREMENT" +

                "," + INST_TYPE_TITLE + "   TEXT  UNIQUE," + INST_TYPE_ACTIVE + " INTEGER );");


        db.execSQL("CREATE TABLE " + AGR_INSTRUMENT + " ( " + INST_SID + " INTEGER PRIMARY KEY AUTOINCREMENT" +
                "," + FARMER_SID + " INTEGER  ," + INST_TYPE_SID + " INTEGER  ," + INST_OWNER_SID + " INTEGER  ," +
                INST_COUNT + " INTEGER , " + INST_NOTES + " TEXT , " + INST_DEL + " INTEGER ," +
                "FOREIGN KEY (" + FARMER_SID + ") REFERENCES " + AGR_FARMER + " (" + FARMER_SID + ") , " +
                "FOREIGN KEY (" + INST_TYPE_SID + ") REFERENCES " + C_TYPE_INSTRUMENT + " (" + INST_TYPE_SID + ") , " +
                "FOREIGN KEY (" + INST_OWNER_SID + ") REFERENCES " + C_OWNER_INSTRUMENT + " (" + INST_OWNER_SID + "));");

        db.execSQL("CREATE TABLE " + C_TYPE_BUILDING + " ( " + TYPE_BUILDING_SID + " INTEGER PRIMARY KEY AUTOINCREMENT" +

                "," + TYPE_BUILDING_TITLE + "   TEXT  UNIQUE," + TYPE_BUILDING_ACTIVE + " INTEGER );");

        db.execSQL("CREATE TABLE " + C_OWNER_BUILDING+ " ( " + OWNER_BUILDING_SID + " INTEGER PRIMARY KEY AUTOINCREMENT" +

                "," + OWNER_BUILDING_TITLE + "   TEXT  UNIQUE," + OWNER_BUILDING_ACTIVE + " INTEGER );");

        db.execSQL("CREATE TABLE " + C_TYPE_FARM+ " ( " + TYPE_FARM_SID + " INTEGER PRIMARY KEY AUTOINCREMENT" +

                "," + TYPE_FARM_TITLE + "   TEXT  UNIQUE," + TYPE_FARM_ACTIVE + " INTEGER );");

        db.execSQL("CREATE TABLE " + C_TYPE_ROOF_FARM+ " ( " + TYPE_ROOF_FARM_SID + " INTEGER PRIMARY KEY AUTOINCREMENT" +

                "," + TYPE_ROOF_FARM_TITLE + "   TEXT  UNIQUE," + TYPE_ROOF_FARM_ACTIVE + " INTEGER );");

        db.execSQL("CREATE TABLE " + C_APPLICATION_IRRIGATION+ " ( " + APPLICATION_IRR_SID + " INTEGER PRIMARY KEY AUTOINCREMENT" +

                "," + APPLICATION_IRR_NAME + "   TEXT  UNIQUE," + APPLICATION_IRR_ACTIVE + " INTEGER );");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + C_QUALIFICATION);
        db.execSQL("DROP TABLE IF EXISTS " + C_SOCIAL_STATUS);
        db.execSQL("DROP TABLE IF EXISTS " + C_TYPE_INSTRUMENT);
        db.execSQL("DROP TABLE IF EXISTS " + C_OWNER_INSTRUMENT);
        db.execSQL("DROP TABLE IF EXISTS " + AGR_INSTRUMENT);
        db.execSQL("DROP TABLE IF EXISTS " + C_TYPE_FARM);
        db.execSQL("DROP TABLE IF EXISTS " + C_TYPE_ROOF_FARM);
        db.execSQL("DROP TABLE IF EXISTS " + C_TYPE_BUILDING);
        db.execSQL("DROP TABLE IF EXISTS " + C_OWNER_BUILDING);
        db.execSQL("DROP TABLE IF EXISTS " + C_APPLICATION_IRRIGATION);



        onCreate(db);
    }

    public boolean insertQualification(String qualificationTitle, String qualificationActive) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(QUALIFICATION_TITLE, qualificationTitle);
        contentValues.put(QUALIFICATION_ACTIVE, qualificationActive);
        long result = db.insert(C_QUALIFICATION, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public ArrayList <String> getQualification() {

        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList <String> qualification = new ArrayList<>();
        Cursor cursor = db.rawQuery("select * from " + C_QUALIFICATION , null);
        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(cursor.getColumnIndex(QUALIFICATION_TITLE));
                qualification.add(name);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return qualification;

    }

    public Integer deleteDataQualification() {

        SQLiteDatabase db = this.getWritableDatabase();

        return db.delete(C_QUALIFICATION, "",new String[]{});

    }

    public boolean insertSocial(String socialTitle, String socialActive) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SOCIAL_STATUS_TITLE, socialTitle);
        contentValues.put(SOCIAL_ACTIVE, socialActive);
        long result = db.insert(C_SOCIAL_STATUS, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public ArrayList <String> getSocial() {

        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList <String> social = new ArrayList<>();
        Cursor cursor = db.rawQuery("select * from " + C_SOCIAL_STATUS , null);
        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(cursor.getColumnIndex(SOCIAL_STATUS_TITLE));
                social.add(name);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return social;

    }

    public Integer deleteDataSocial() {

        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(C_QUALIFICATION, "",new String[]{});

    }


    public boolean insertCity(String cityTitle, String cityActive) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(CITY_Name, cityTitle);
        contentValues.put(CITY_ACTIVE, cityActive);
        long result = db.insert(C_CITY, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public ArrayList <String> getCity() {

        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList <String> course = new ArrayList<>();
        Cursor cursor = db.rawQuery("select * from " + C_CITY , null);
        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(cursor.getColumnIndex(CITY_Name));
                course.add(name);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return course;

    }
    public boolean insertSector(String cityId, String sectorName) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SECTOR_Name, sectorName);
        contentValues.put(CITY_SID, cityId);
        long result = db.insert(C_SECTOR, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public ArrayList <String> getSector(String  cityID) {

        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList <String> course = new ArrayList<>();
        Cursor cursor = db.rawQuery("select * from " + C_SECTOR+" where ("+CITY_SID+" = " +cityID +")", null);
        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(cursor.getColumnIndex(SECTOR_Name));
                course.add(name);
            } while (cursor.moveToNext());
        }
        cursor.close();
        Log.d("ccccccc",course.size()+"");
        return course;

    }

    public boolean insertOwnerInst(String ownerName, String ownerActive) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(INST_OWNER_TITLE, ownerName);
        contentValues.put(INST_OWNER_ACTIVE, ownerActive);
        long result = db.insert(C_OWNER_INSTRUMENT, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public ArrayList <String> getOwnerInst() {

        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList <String> course = new ArrayList<>();
        Cursor cursor = db.rawQuery("select * from " + C_OWNER_INSTRUMENT , null);
        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(cursor.getColumnIndex(INST_OWNER_TITLE));


                course.add(name);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return course;

    }
    public boolean insertTypeInst(String ownerName, String ownerActive) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(INST_TYPE_TITLE, ownerName);
        contentValues.put(INST_TYPE_ACTIVE, ownerActive);
        long result = db.insert(C_TYPE_INSTRUMENT, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public ArrayList <String> getTypeInst() {

        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList <String> course = new ArrayList<>();
        Cursor cursor = db.rawQuery("select * from " + C_TYPE_INSTRUMENT , null);
        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(cursor.getColumnIndex(INST_TYPE_TITLE));
                course.add(name);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return course;

    }

    public boolean insertTypeBuilding(String typeBuildingName, String typeBuildingActive) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TYPE_BUILDING_TITLE, typeBuildingName);
        contentValues.put(TYPE_BUILDING_ACTIVE, typeBuildingActive);
        long result = db.insert(C_TYPE_BUILDING, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public ArrayList <String> getTypeBuilding() {

        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList <String> course = new ArrayList<>();
        Cursor cursor = db.rawQuery("select * from " + C_TYPE_BUILDING , null);
        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(cursor.getColumnIndex(TYPE_BUILDING_TITLE));
                course.add(name);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return course;

    }


    public boolean insertOwnerBuilding(String typeBuildingName, String typeBuildingActive) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(OWNER_BUILDING_TITLE, typeBuildingName);
        contentValues.put(OWNER_BUILDING_ACTIVE, typeBuildingActive);
        long result = db.insert(C_OWNER_BUILDING, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public ArrayList <String> getOwnerBuilding() {

        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList <String> course = new ArrayList<>();
        Cursor cursor = db.rawQuery("select * from " + C_OWNER_BUILDING , null);
        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(cursor.getColumnIndex(OWNER_BUILDING_TITLE));
                course.add(name);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return course;

    }

    public boolean insertTypeFarm(String farmName, String farmActive) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TYPE_FARM_TITLE, farmName);
        contentValues.put(TYPE_FARM_ACTIVE, farmActive);
        long result = db.insert(C_TYPE_INSTRUMENT, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public ArrayList <String> getTypeFarm() {

        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList <String> course = new ArrayList<>();
        Cursor cursor = db.rawQuery("select * from " + C_TYPE_FARM , null);
        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(cursor.getColumnIndex(TYPE_FARM_TITLE));
                course.add(name);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return course;

    }


    public boolean insertTypeRoofFarm(String farmRoofName, String farmRoofActive) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TYPE_ROOF_FARM_TITLE, farmRoofName);
        contentValues.put(TYPE_ROOF_FARM_ACTIVE, farmRoofActive);
        long result = db.insert(C_TYPE_ROOF_FARM, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public ArrayList <String> getTypeRoofFarm() {

        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList <String> course = new ArrayList<>();
        Cursor cursor = db.rawQuery("select * from " + C_TYPE_ROOF_FARM , null);
        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(cursor.getColumnIndex(TYPE_ROOF_FARM_TITLE));
                course.add(name);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return course;

    }


    public boolean insertApplicationIRR(String applicationTitle, String applicationActive) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(APPLICATION_IRR_NAME, applicationTitle);
        contentValues.put(APPLICATION_IRR_ACTIVE, applicationActive);
        long result = db.insert(C_APPLICATION_IRRIGATION, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public ArrayList <String> getApplicationIRR() {

        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList <String> qualification = new ArrayList<>();
        Cursor cursor = db.rawQuery("select * from " + C_APPLICATION_IRRIGATION , null);
        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(cursor.getColumnIndex(APPLICATION_IRR_NAME));
                qualification.add(name);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return qualification;

    }

}