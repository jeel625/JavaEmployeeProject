public class Address
{
    private int streetNumber;
    private String streetName;
    private String province;

    public Address(int streetNumber, String streetName, String province, String country) {
        this.streetNumber=streetNumber;
        this.streetName=streetName;
        this.province=province;
        this.country=country;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber=streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName=streetName;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province=province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country=country;
    }

    private String country;
    Address()
    {

    }
    public String getAddress()
    {
        String address="";
        address="Street Num :"+this.streetNumber+" Stret name : "+this.getStreetName()+" Province : "+this.getProvince()+" Country :"+this.getCountry();
        return address;
    }
}
