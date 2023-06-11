public interface VentaRepository extends JpaRepository<Venta, Long> {
    List<Venta> findByFechaPagoIsNull(); // Recupera todas las ventas no pagadas
    List<Venta> findByFechaPagoIsNotNull(); // Recupera todas las ventas pagadas
}
