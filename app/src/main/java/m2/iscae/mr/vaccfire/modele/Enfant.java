package m2.iscae.mr.vaccfire.modele;

public class Enfant {
    private  String Nom;
    private  String Prenom;
    private  Integer Age;
    private  Integer TelParent;


    private  String Lieu;
    private  String Type_vaccination;

    public Enfant(String nom, String prenom, Integer age, Integer telParent,String Lieu,String Type_vaccination) {
        Nom = nom;
        Prenom = prenom;
        Age = age;
        TelParent = telParent;
        this.Lieu =Lieu;
        this.Type_vaccination = Type_vaccination;

    }

    public Enfant () {

    }

    public void setNom (String nom) {
        Nom = nom;
    }

    public void setPrenom (String prenom) {
        Prenom = prenom;
    }

    public void setAge (Integer age) {
        Age = age;
    }

    public void setTelParent (Integer telParent) {
        TelParent = telParent;
    }

    public void setLieu (String lieu) {
        Lieu = lieu;
    }

    public void setType_vaccination (String type_vaccination) {
        Type_vaccination = type_vaccination;
    }

    public String getLieu() { return Lieu; }

    public String getNom() {
        return Nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public Integer getAge() {
        return Age;
    }

    public Integer getTelParent() {
        return TelParent;
    }

    public String getType_vaccination() {
        return Type_vaccination;
    }


}



