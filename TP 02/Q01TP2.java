import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class Q01TP2 {

  // Método para converter a string de nomes alternativos em uma lista de strings
  public static List<String> parseLista(String listaString) {
    // Remover colchetes e espaços extras
    listaString = listaString.replaceAll("\\[|\\]", "").trim();
    // Dividir os elementos separados por vírgula e espaços
    String[] elementos = listaString.split(",\\s*");
    List<String> lista = new ArrayList<>();
    for (String elemento : elementos) {
      lista.add(elemento);
    }
    return lista;
  }

  public static boolean parseBoolean(String str) {
    if (str.equals("VERDADEIRO")) {
      return true;
    } else {
      return false;
    }
  }

  public static void encontrarId(List<personagem> personagens, String id) {
    for (personagem personagem : personagens) {
      if (personagem.getId().equals(id)) {
        System.out.println(personagem);
      }
    }
  }

  public static class personagem {

    private String id;
    private String name;
    private List<String> alternateNames;
    private String house;
    private String ancestry;
    private String species;
    private String patronus;
    private boolean hogwartsStaff;
    private boolean hogwartsStudent;
    private String actorName;
    private boolean alive;
    private List<String> alternateActors;
    private String dateOfBirth;
    private String yearOfBirth;
    private String eyeColour;
    private String gender;
    private String hairColour;
    private boolean wizard;

    public personagem() {}

    public personagem(
      String id,
      String name,
      List<String> alternateNames,
      String house,
      String ancestry,
      String species,
      String patronus,
      boolean hogwartsStaff,
      boolean hogwartsStudent,
      String actorName,
      boolean alive,
      List<String> alternateActors,
      String dateOfBirth,
      String yearOfBirth,
      String eyeColour,
      String gender,
      String hairColour,
      boolean wizard
    ) {
      this.id = id;
      this.name = name;
      this.alternateNames = alternateNames;
      this.house = house;
      this.ancestry = ancestry;
      this.species = species;
      this.patronus = patronus;
      this.hogwartsStaff = hogwartsStaff;
      this.hogwartsStudent = hogwartsStudent;
      this.actorName = actorName;
      this.alive = alive;
      this.alternateActors = alternateActors;
      this.dateOfBirth = dateOfBirth;
      this.yearOfBirth = yearOfBirth;
      this.eyeColour = eyeColour;
      this.gender = gender;
      this.hairColour = hairColour;
      this.wizard = wizard;
    }

    public String getId() {
      return id;
    }

    public void setId(String id) {
      this.id = id;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public List<String> getAlternateNames() {
      return alternateNames;
    }

    public void setAlternateNames(List<String> alternateNames) {
      this.alternateNames = alternateNames;
    }

    public String getHouse() {
      return house;
    }

    public void setHouse(String house) {
      this.house = house;
    }

    public String getAncestry() {
      return ancestry;
    }

    public void setAncestry(String ancestry) {
      this.ancestry = ancestry;
    }

    public String getSpecies() {
      return species;
    }

    public void setSpecies(String species) {
      this.species = species;
    }

    public String getPatronus() {
      return patronus;
    }

    public void setPatronus(String patronus) {
      this.patronus = patronus;
    }

    public boolean isHogwartsStaff() {
      return hogwartsStaff;
    }

    public void setHogwartsStaff(boolean hogwartsStaff) {
      this.hogwartsStaff = hogwartsStaff;
    }

    public boolean getHogwartsStudent() {
      return hogwartsStudent;
    }

    public void setHogwartsStudent(boolean hogwartsStudent) {
      this.hogwartsStudent = hogwartsStudent;
    }

    public String getActorName() {
      return actorName;
    }

    public void setActorName(String actorName) {
      this.actorName = actorName;
    }

    public boolean isAlive() {
      return alive;
    }

    public void setAlive(boolean alive) {
      this.alive = alive;
    }

    public List<String> getAlternateActors() {
      return alternateActors;
    }

    public void setAlternateActors(List<String> alternateActors) {
      this.alternateActors = alternateActors;
    }

    public String getDateOfBirth() {
      return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
      this.dateOfBirth = dateOfBirth;
    }

    public String getYearOfBirth() {
      return yearOfBirth;
    }

    public void setYearOfBirth(String yearOfBirth) {
      this.yearOfBirth = yearOfBirth;
    }

    public String getEyeColour() {
      return eyeColour;
    }

    public void setEyeColour(String eyeColour) {
      this.eyeColour = eyeColour;
    }

    public String getGender() {
      return gender;
    }

    public void setGender(String gender) {
      this.gender = gender;
    }

    public String getHairColour() {
      return hairColour;
    }

    public void setHairColour(String hairColour) {
      this.hairColour = hairColour;
    }

    public boolean isWizard() {
      return wizard;
    }

    public void setWizard(boolean wizard) {
      this.wizard = wizard;
    }

    @Override
    public String toString() {
      StringBuilder alternateNamesString = new StringBuilder("{");
      for (int i = 0; i < alternateNames.size(); i++) {
        String alternateName = alternateNames.get(i);
        // Remover as aspas simples do início e do fim do termo
        alternateName = alternateName.replaceAll("^'|'$", "");
        alternateNamesString.append(alternateName);
        if (i < alternateNames.size() - 1) {
          alternateNamesString.append(", ");
        }
      }
      alternateNamesString.append("}");

      return (
        "[" +
        id +
        " ## " +
        name +
        " ## " +
        alternateNamesString.toString() +
        " ## " +
        house +
        " ## " +
        ancestry +
        " ## " +
        species +
        " ## " +
        patronus +
        " ## " +
        hogwartsStaff +
        " ## " +
        hogwartsStudent +
        " ## " +
        actorName +
        " ## " +
        alive +
        " ## " +
        dateOfBirth +
        " ## " +
        yearOfBirth +
        " ## " +
        eyeColour +
        " ## " +
        gender +
        " ## " +
        hairColour +
        " ## " +
        wizard +
        "]"
      );
    }

    public static personagem lerPersonagem(
      String id,
      String name,
      List<String> alternateNames,
      String house,
      String ancestry,
      String species,
      String patronus,
      boolean hogwartsStaff,
      boolean hogwartsStudent,
      String actorName,
      boolean alive,
      List<String> alternateActors,
      String dateOfBirth,
      String yearOfBirth,
      String eyeColour,
      String gender,
      String hairColour,
      boolean wizard
    ) {
      return new personagem(
        id,
        name,
        alternateNames,
        house,
        ancestry,
        species,
        patronus,
        hogwartsStaff,
        hogwartsStudent,
        actorName,
        alive,
        alternateActors,
        dateOfBirth,
        yearOfBirth,
        eyeColour,
        gender,
        hairColour,
        wizard
      );
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
      return super.clone();
    }
  }

  public static void main(String[] args) {
    String arquivoCSV = "/tmp/characters.csv";
    List<personagem> personagens = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    try (
      BufferedReader reader = new BufferedReader(new FileReader(arquivoCSV))
    ) {
      // Ler e pular a primeira linha
      reader.readLine();
      String linha;
      while ((linha = reader.readLine()) != null) {
        String[] dados = linha.split(";"); // Utilizando o ponto e vírgula como separador
        personagem personagem = new personagem(
          dados[0], // id
          dados[1], // name
          parseLista(dados[2]), // alternateNames
          dados[3], // house
          dados[4], // ancestry
          dados[5], // species
          dados[6], // patronus
          parseBoolean(dados[7]), // hogwartsStaff
          parseBoolean(dados[8]), // hogwartsStudent
          dados[9], // actorName
          parseBoolean(dados[10]), // alive
          parseLista(dados[11]), // alternateActors
          dados[12], // dateOfBirth
          dados[13], // yearOfBirth
          dados[14], // eyeColour
          dados[15], // gender
          dados[16], // hairColour
          parseBoolean(dados[17]) // wizard
        );
        // Adicionar o personagem à lista
        personagens.add(personagem);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    String entrada = sc.nextLine();
    while (!(entrada.equals("FIM"))) {
      encontrarId(personagens, entrada);
      entrada = sc.nextLine();
    }
  }
}
