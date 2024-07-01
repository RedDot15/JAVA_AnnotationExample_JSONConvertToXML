package entity;

import org.json.simple.JSONObject;
import xml.XmlElement;
import xml.XmlObject;
import xml.XmlRootElement;

@XmlRootElement(name = "user")
public class User {
    @XmlElement(name = "id")
    private Long id;
    @XmlElement(name = "name")
    private String name;
    @XmlElement(name = "username")
    private String username;
    @XmlElement(name = "email")
    private String email;
    @XmlObject(name = "address")
    private Address address;
    @XmlElement(name = "phone")
    private String phone;
    @XmlElement(name = "website")
    private String website;
    @XmlObject(name = "company")
    private Company company;

    public User(Long id, String name, String username, String email, JSONObject address, String phone, String website, JSONObject company) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.website = website;

        this.address = new Address((String) address.get("street"), (String) address.get("suite"), (String) address.get("city"),
                (String) address.get("zipcode"), (JSONObject) address.get("geo"));
        this.company = new Company((String) company.get("name"), (String) company.get("catchPhrase"), (String) company.get("bs"));
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", address=" + address +
                ", phone='" + phone + '\'' +
                ", website='" + website + '\'' +
                ", company=" + company +
                '}';
    }
}
