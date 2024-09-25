import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Material> materiais;

    public Biblioteca() {
        materiais = new ArrayList<>();
    }

    public void adicionarMaterial(Material material) {
        materiais.add(material);
        System.out.println("Novo material cadastrado com sucesso!");
    }

    public void listarMateriais() {
        if (materiais.isEmpty()) {
            System.out.println("Nenhum material cadastrado.");
        } else {
            for (Material material : materiais) {
                System.out.println(material);
            }
        }
    }

    public Material pesquisarMaterial(String titulo) {
        for (Material material : materiais) {
            if (material.getTitulo().equalsIgnoreCase(titulo)) {
                return material;
            }
        }
        return null;
    }

    public void excluirMaterial(String titulo) {
        Material material = pesquisarMaterial(titulo);
        if (material != null) {
            materiais.remove(material);
            System.out.println("Material excluído com sucesso!");
        } else {
            System.out.println("Material não encontrado.");
        }
    }
}
