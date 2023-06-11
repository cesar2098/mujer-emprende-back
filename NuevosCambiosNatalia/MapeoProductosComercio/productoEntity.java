@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Otros atributos y relaciones

    @ManyToOne
    @JoinColumn(name = "comercio_id")
    private Comercio comercio;

    // Getters y setters
}
