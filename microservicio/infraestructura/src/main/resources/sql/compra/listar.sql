select c.id, c.identificador_usuario,c.direccion,c.ciudad,c.tipo_usuario,c.producto_id,p.codigo_producto,p.nombre as nombre_producto,
p.valor_producto,c.fecha_compra,c.fecha_entrega
from compra c
join producto p
on c.producto_id = p.id
