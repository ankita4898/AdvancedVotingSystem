/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login1;

import javafx.scene.image.ImageView;

/**
 *
 * @author bap39
 */
public class CandidateTable {
    
    String c_name, c_party,c_vote,c_id;
ImageView c_sign;

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public ImageView getC_sign() {
        return c_sign;
    }

    public void setC_sign(ImageView c_sign) {
        this.c_sign = c_sign;
    }

    public String getC_party() {
        return c_party;
    }

    public void setC_party(String c_party) {
        this.c_party = c_party;
    }

    public String getC_vote() {
        return c_vote;
    }

    public void setC_vote(String c_vote) {
        this.c_vote = c_vote;
    }
    public String getC_id() {
        return c_id;
    }

    public void setC_id(String c_id) {
        this.c_id = c_id;
    }
    public CandidateTable(String c_name, ImageView c_sign, String c_party,String c_id) {
        this.c_name = c_name;
        this.c_sign = c_sign;
        this.c_party = c_party;
        this.c_id=c_id;
    }
}
