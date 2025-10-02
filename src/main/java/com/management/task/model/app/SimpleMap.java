package com.management.task.model.app;

import java.util.HashMap;
import java.util.Map;

// extends hansmap dengan key=String dan value=Object bisa isi apa saja.
public class SimpleMap extends HashMap<String, Object> {

    // kita buat methode (static) dengan nama CreateMap bluePrint
    // dari Class SimpleMap yg sudah extend dari HashMap<String, Object>.
    // dipanggil melalui class dan bisa langsung dipanggil method ini dari class.
    public static SimpleMap createMap(){
        return new SimpleMap();
    }

    // kita buat method add (non-static) untuk manipulasi object.
    // dari Class SimpleMap yg sudah extend dari HashMap<String, Object>. yang mempunyai methode put()
    // dipanggil melalui object harus new dari kelas SimpleMap untuk memakai method ini // beda dengan static yang bisa langsung dipakai dari class.
    // key = nama/umur/dll dan val=dikin/25/dll
    public SimpleMap add(String key, Object val) {

        this.put(key, val);
        return this;

    }

    // didalam java kita bisa buat nama methode yang sama ketika dipakai yang membedakan ada parameter
    // buat static seperti createMap baru methode yang bisa diisi dengan parameter dan return dengan method add.
    // karena ada parameter data pertama bisa langsung dimasukan parameter Map.
    public static SimpleMap createMap(String key, Object val){
        return createMap().add(key, val);
    }

    // buat methode addIfNotExist() jika key belum ada masukan data.
    // bisa di akses melalui object dari internal maupun eksternal
    public SimpleMap addIfNotExist(String key, Object val) {

        if (!this.containsKey(key)) { // cek jika map key tidak ada, key ditambahkan
            this.put(key, val);
        }
        return this; // // jika sudah ada return data yang sudah ada dan tidak ditulis lagi.
    }

    // <T> T →: method bisa mengembalikan apa saja (String, Integer, dll). T itu seperti nama sementara untuk tipe yang kita mau.
    //get(String key, Class<T> tClass) → kita minta dua hal:
    //key = nama label barang yang mau diambil (harus string),
    //tClass = kita bilang ke Java “tolong ubah barang ini jadi tipe Class<T> T” (mis. String.class atau Integer.class).
    public <T> T get(String key, Class<T> tClass){

        //Jika label/key tidak ada return null
        if(!this.containsKey(key))
            return null;

        // cast itu perintah mengubah data menjadi Tclass
        return tClass.cast(this.get(key));

    }

    // buat public supaya method bisa digunakan diluar tetapi tetap lewat class
    // buat generc type <T> kind of type dikembalikan di variable T.
    // buat method getOrDefault() dengan 3 parameter String,T,Class<T>.
    // validasi memanggil this.constainkey method dari map
    // this merujuk ke object kelas yang dibuat
    // this.constainKey() = milikobject, key = parameter
    // apakah object berisi key dari parameter? ya return key
    // tidak kembalikan default value.
    // Validasi jika key=parameter tidak ada di !this.contaisKey
    // return defaultValue
    public <T> T getOrDefault(String key, T defaultvalue, Class<T> tClass){

        if (!this.containsKey(key)){
            return defaultvalue;
        }

        return tClass.cast(this.get(key));
    }

    // buat public static dengan class SimpleMap dan methode from()
    // parameter dalam (Map<String, object> origin) untuk menyalin data yang sama tetapi beda variable.
    // buat class baru buat dengan new SimpleMap untuk menyalid data baru dari origin.
    // map.putAll(origin);
    // return map;
    public static SimpleMap from(Map<String, Object> origin){
        SimpleMap map = new SimpleMap();
        map.putAll(origin);
        return map;
    }




}
