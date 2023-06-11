@Service
public class VentaService {
    private final VentaRepository ventaRepository;

    public VentaService(VentaRepository ventaRepository) {
        this.ventaRepository = ventaRepository;
    }

    public boolean marcarVentaComoPagada(Long ventaId, LocalDate fechaPago) {
        Optional<Venta> ventaOptional = ventaRepository.findById(ventaId);

        if (ventaOptional.isPresent()) {
            Venta venta = ventaOptional.get();
            venta.setFechaPago(fechaPago);
            ventaRepository.save(venta);
            return true;
        }

        return false;
    }
}
