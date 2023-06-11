@RestController
@RequestMapping("/comercios")
public class ComercioController {
    private final ComercioService comercioService;

    public ComercioController(ComercioService comercioService) {
        this.comercioService = comercioService;
    }

    @GetMapping("/{comercioId}/productos")
    public List<Producto> getProductosPorComercio(@PathVariable Long comercioId) {
        return comercioService.getProductosPorComercio(comercioId);
    }
}
