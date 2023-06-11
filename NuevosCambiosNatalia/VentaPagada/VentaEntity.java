@Entity
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Otros atributos y relaciones

    private LocalDate fechaPago;

    // Getters y setters
}
