import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Q01TP3 {

    // Método para converter a string de nomes alternativos em uma lista de strings
    public static List<String> parseLista(String listaString) {
        listaString = listaString.replaceAll("\\[|\\]", "").trim();
        String[] elementos = listaString.split(",\\s*");
        return new ArrayList<>(Arrays.asList(elementos));
    }

    public static boolean parseBoolean(String str) {
        return str.equalsIgnoreCase("VERDADEIRO");
    }

    public static void adicionarPersonagemPorId(List<Personagem> personagens, List<Personagem> novaLista, String id) {
        for (Personagem personagem : personagens) {
            if (personagem.getId().equals(id)) {
                novaLista.add(personagem);
                return; // Encontrou e adicionou o personagem, pode parar de buscar
            }
        }
    }

    public static Personagem encontrarPersonagemPorId(List<Personagem> personagens, String id) {
        for (Personagem personagem : personagens) {
            if (personagem.getId().equals(id)) {
                return personagem;
            }
        }
        return null;
    }

    public static class Personagem {
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

        // Construtor com todos os parâmetros
        public Personagem(String id, String name, List<String> alternateNames, String house, String ancestry,
                String species, String patronus, boolean hogwartsStaff, boolean hogwartsStudent, String actorName,
                boolean alive, List<String> alternateActors, String dateOfBirth, String yearOfBirth, String eyeColour,
                String gender, String hairColour, boolean wizard) {
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

        public boolean isHogwartsStudent() {
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
                alternateName = alternateName.replaceAll("^'|'$", "");
                alternateNamesString.append(alternateName);
                if (i < alternateNames.size() - 1) {
                    alternateNamesString.append(", ");
                }
            }
            alternateNamesString.append("}");

            return (id +
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
                    "]");
        }
    }

    public static void main(String[] args) {
        String arquivoCSV = "/tmp/characters.csv";
        List<Personagem> personagens = new ArrayList<>();
        List<Personagem> novaLista = new ArrayList<>();
        List<Personagem> personagensRemovidos = new ArrayList<>();

        // Ler personagens do arquivo CSV
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivoCSV))) {
            // Ler e pular a primeira linha
            reader.readLine();
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";", -1); // Usar -1 para incluir strings vazias
                if (dados.length < 18) {
                    System.err.println("Linha com dados incompletos: " + linha);
                    continue;
                }

                Personagem personagem = new Personagem(
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
                personagens.add(personagem);
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        // Ler IDs de entrada
        Scanner sc = new Scanner(System.in);
        String entrada = sc.nextLine();
        while (!entrada.equalsIgnoreCase("FIM")) {
            Personagem personagem = encontrarPersonagemPorId(personagens, entrada);
            if (personagem != null) {
                novaLista.add(personagem);
            }
            entrada = sc.nextLine();
        }

        // Solicitar número de operações de inserção/remoção
        int numeroOperacoes = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < numeroOperacoes; i++) {
            String operacao = sc.nextLine();
            String[] partes = operacao.split(" ");
            String tipoOperacao = partes[0];

            switch (tipoOperacao) {
                case "II":
                    if (partes.length > 1) {
                        String id = partes[1];
                        Personagem personagem = encontrarPersonagemPorId(personagens, id);
                        if (personagem != null) {
                            novaLista.add(0, personagem);
                        }
                    }
                    break;
                case "IF":
                    if (partes.length > 1) {
                        String id = partes[1];
                        Personagem personagem = encontrarPersonagemPorId(personagens, id);
                        if (personagem != null) {
                            novaLista.add(personagem);
                        }
                    }
                    break;
                case "I*":
                    if (partes.length > 2) {
                        int posicao = Integer.parseInt(partes[1]);
                        String id = partes[2];
                        Personagem personagem = encontrarPersonagemPorId(personagens, id);
                        if (personagem != null && posicao >= 0 && posicao <= novaLista.size()) {
                            novaLista.add(posicao, personagem);
                        }
                    }
                    break;
                case "RI":
                    if (!novaLista.isEmpty()) {
                        personagensRemovidos.add(novaLista.remove(0));
                    }
                    break;
                case "RF":
                    if (!novaLista.isEmpty()) {
                        personagensRemovidos.add(novaLista.remove(novaLista.size() - 1));
                    }
                    break;
                case "R*":
                    if (partes.length > 1) {
                        int posicao = Integer.parseInt(partes[1]);
                        if (posicao >= 0 && posicao < novaLista.size()) {
                            personagensRemovidos.add(novaLista.remove(posicao));
                        }
                    }
                    break;
                default:
                    System.out.println("Operação inválida: " + operacao);
                    break;
            }
        }
        sc.close();

        // Printar personagens removidos
        for (Personagem personagem : personagensRemovidos) {
            System.out.println("(R) " + personagem.getName());
        }

        // Printar personagens na nova lista com índice
        for (int i = 0; i < novaLista.size(); i++) {
            System.out.println("[" + i + " " + "##" + " " + novaLista.get(i).toString());
        }
    }
}
