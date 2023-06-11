@Entity
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Otros atributos y relaciones

    private LocalDate fechaNula;

    private String observaciones;

    // Getters y setters
}
