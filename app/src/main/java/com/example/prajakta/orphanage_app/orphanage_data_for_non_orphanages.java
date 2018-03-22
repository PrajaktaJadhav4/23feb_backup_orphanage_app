package com.example.prajakta.orphanage_app;

/**
 * Created by PRAJAKTA on 10-03-2018.
 */

public class orphanage_data_for_non_orphanages {

    private String orphanage_name;
    private String orphanage_address;




    public orphanage_data_for_non_orphanages(String orphanage_name, String orphanage_address) {
        this.orphanage_name = orphanage_name;
        this.orphanage_address = orphanage_address;
    }

    public String get_o_name() {
        return orphanage_name;
    }

    public String get_o_address() {
        return orphanage_address;
    }




}
