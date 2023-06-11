@Service
public class VentaService {
    private final VentaRepository ventaRepository;

    public VentaService(VentaRepository ventaRepository) {
        this.ventaRepository = ventaRepository;
    }

    public boolean anularVenta(Long ventaId, LocalDate fechaNula, String observaciones) {
        Optional<Venta> ventaOptional =
