@RestController
@RequestMapping("/ventas")
public class VentaController {
    private final VentaService ventaService;

    public VentaController(VentaService ventaService) {
        this.ventaService = ventaService;
    }

    @PutMapping("/{ventaId}/pagar")
    public ResponseEntity<String> marcarVentaComoPagada(@PathVariable Long ventaId, @RequestBody PagoVentaRequest request) {
        if (ventaService.marcarVentaComoPagada(ventaId, request.getFechaPago())) {
            return ResponseEntity.ok("Venta marcada como pagada exitosamente");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
