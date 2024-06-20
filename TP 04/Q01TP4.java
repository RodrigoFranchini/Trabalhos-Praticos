import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q01TP4 {

    public static List<String> parseLista(String listaString) {
        listaString = listaString.replaceAll("\\[|\\]", "").trim();
        String[] elementos = listaString.split(",\\s*");
        List<String> lista = new ArrayList<>();
        for (String elemento : elementos) {
            lista.add(elemento);
        }
        return lista;
    }

    public static boolean parseBoolean(String str) {
        return str.equals("VERDADEIRO");
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

        public personagem() {
        }

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
                boolean wizard) {
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

        public String getName() {
            return name;
        }
    }

    class Node {
        String key;
        personagem data;
        Node left, right;

        public Node(personagem data) {
            this.key = data.getName();
            this.data = data;
            left = right = null;
        }
    }

    class BinaryTree {
        Node root;

        public BinaryTree() {
            root = null;
        }

        public void insert(personagem data) {
            root = insertRec(root, data);
        }

        private Node insertRec(Node root, personagem data) {
            if (root == null) {
                root = new Node(data);
                return root;
            }

            if (data.getName().compareTo(root.key) < 0) {
                root.left = insertRec(root.left, data);
            } else if (data.getName().compareTo(root.key) > 0) {
                root.right = insertRec(root.right, data);
            }

            return root;
        }

        public String search(String key) {
            return searchRec(root, key, "raiz");
        }

        private String searchRec(Node root, String key, String path) {
            if (root == null) {
                return path + " NAO";
            }

            if (root.key.equals(key)) {
                return path + " SIM";
            }

            if (key.compareTo(root.key) < 0) {
                return searchRec(root.left, key, path + " esq");
            } else {
                return searchRec(root.right, key, path + " dir");
            }
        }

        public String searchWithOutput(String name) {
            String result = search(name);
            return name + " => " + result;
        }
    }

    public static void main(String[] args) {
        String arquivoCSV = "/tmp/characters.csv";
        List<personagem> personagens = new ArrayList<>();
        BinaryTree tree = new Q01TP4().new BinaryTree();
        Scanner sc = new Scanner(System.in);

        try (BufferedReader reader = new BufferedReader(new FileReader(arquivoCSV))) {
            reader.readLine(); // Ler e pular a primeira linha
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
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
                personagens.add(personagem);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Ler IDs de personagens para inserção na árvore
        while (true) {
            String entrada = sc.nextLine();
            if (entrada.equals("FIM"))
                break;
            for (personagem p : personagens) {
                if (p.getId().equals(entrada)) {
                    tree.insert(p);
                    break;
                }
            }
        }

        // Ler nomes de personagens para busca na árvore
        while (true) {
            String entrada = sc.nextLine();
            if (entrada.equals("FIM"))
                break;
            String resultado = tree.searchWithOutput(entrada);
            System.out.println(resultado);
        }

    }
}
