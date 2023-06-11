@Entity
public class Comercio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Otros atributos y relaciones

    @OneToMany(mappedBy = "comercio")
    private List<Producto> productos;

    // Getters y setters
}
