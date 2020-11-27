/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login1;

/**
 *
 * @author bap39
 */
public class ModelTable {
    
    String name, address, voterid2, city, taluka, district, state, constituency;

     public ModelTable(String name, String address, String voterid2, String city, String taluka, String district, String state, String constituency) {
        this.name = name;
        this.address = address;
        this.voterid2 = voterid2;
        this.city = city;
        this.taluka = taluka;
        this.district = district;
        this.state = state;
        this.constituency = constituency;
  
    }

    

    ModelTable(String string, String string0, String string1, String string2, String string3) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getTaluka() {
        return taluka;
    }

    public String getDistrict() {
        return district;
    }

    public String getState() {
        return state;
    }

    public String getConstituency() {
        return constituency;
    }

     public String getVoterid2() {
        return voterid2;
    }
   
   
    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setTaluka(String taluka) {
        this.taluka = taluka;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setConstituency(String constituency) {
        this.constituency = constituency;
    }

    
    public void setVoterid2(String voterid2) {
        this.voterid2 = voterid2;
    }

   
    
}
