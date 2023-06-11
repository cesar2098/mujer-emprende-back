public interface VentaRepository extends JpaRepository<Venta, Long> {
    List<Venta> findByFechaNulaIsNull(); // Recupera todas las ventas no anuladas
    List<Venta> findByFechaNulaIsNotNull(); // Recupera todas las ventas anuladas
}
