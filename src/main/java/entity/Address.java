package entity;

import org.json.simple.JSONObject;
import xml.XmlElement;
import xml.XmlElementWrapper;
import xml.XmlObjectElement;
import xml.XmlRootElement;

@XmlRootElement(name = "address")
public class Address {
    @XmlElement(name = "street")
    private String street;
    @XmlElement(name = "suite")
    private String suite;
    @XmlElement(name = "city")
    private String city;
    @XmlElement(name = "zipcode")
    private String zipcode;
    @XmlObjectElement(name = "geo")
    private Geo geo;

    public Address(String street, String suite, String city, String zipcode, JSONObject geo) {
        this.street = street;
        this.suite = suite;
        this.city = city;
        this.zipcode = zipcode;
        this.geo = new Geo((String) geo.get("lat"), (String) geo.get("lng"));
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", suite='" + suite + '\'' +
                ", city='" + city + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", geo=" + geo +
                '}';
    }
}
