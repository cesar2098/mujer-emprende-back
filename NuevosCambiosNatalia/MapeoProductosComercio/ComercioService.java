@Service
public class ComercioService {
    private final ComercioRepository comercioRepository;
    private final ProductoRepository productoRepository;

    public ComercioService(ComercioRepository comercioRepository, ProductoRepository productoRepository) {
        this.comercioRepository = comercioRepository;
        this.productoRepository = productoRepository;
    }

    public List<Producto> getProductosPorComercio(Long comercioId) {
        Optional<Comercio> comercioOptional = comercioRepository.findById(comercioId);

        if (comercioOptional.isPresent()) {
            Comercio comercio = comercioOptional.get();
            return comercio.getProductos();
        }

        return Collections.emptyList();
    }
}
