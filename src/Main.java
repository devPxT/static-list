public class Main {
    public static void main(String[] args) throws Exception {
        StaticList<Integer> list = new StaticList<>(5);
        System.out.println("------- Static List -------");
        System.out.println("A lista está vazia? " + list.isEmpty());

        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println("A lista está vazia? " + list.isEmpty());

        System.out.println("Elemento removido: " + list.remove(1)); //elemento na posição 1

        list.add(40);
        list.add(50);
        list.add(60); //(fim da lista)

        try {
            System.out.println("Tentando adicionar elemento na lista cheia");
            list.add(70);
        } catch (IllegalStateException e) {
            System.out.println("Erro ao adicionar elemento: " + e.getMessage());
        }

        System.out.println("A lista está cheia? " + list.isFull());

        System.out.println("Elemento removido na posição 0: " + list.remove(0));
        System.out.println("Elemento removido na posição 0: " + list.remove(0));
        System.out.println("Elemento removido na posição 0: " + list.remove(0));
        System.out.println("Elemento removido na posição 0: " + list.remove(0));
        System.out.println("Elemento removido na posição 0: " + list.remove(0));
        
        try {
            System.out.println("Tentando remover elemento em lista vazia: " + list.remove(0));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Erro ao remover elemento: " + e.getMessage());
        }

        list.add(80);
        list.add(90);
        list.clear();
        System.out.println("A lista está vazia após o clear()? " + list.isEmpty());
    }
}