@RestController
@RequestMapping("/ventas")
public class VentaController {
    private final VentaService ventaService;

    public VentaController(VentaService ventaService) {
        this.ventaService = ventaService;
    }

    @PutMapping("/{ventaId}/anular")
    public ResponseEntity<String> anularVenta(@PathVariable Long ventaId, @RequestBody AnulacionVentaRequest request) {
        if (ventaService.anularVenta(ventaId, request.getFechaNula(), request.getObservaciones())) {
            return ResponseEntity.ok("Venta anulada exitosamente");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
