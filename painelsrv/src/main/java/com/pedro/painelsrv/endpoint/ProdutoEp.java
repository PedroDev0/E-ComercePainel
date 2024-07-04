package com.pedro.painelsrv.endpoint;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.pedro.painelsrv.business.ProdutoBss;
import com.pedro.painelsrv.domain.Produto;
import com.pedro.painelsrv.endpoint.dto.ProdutoDto;

@Path("/product")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoEp {

	@EJB
	ProdutoBss prodBss;

	@GET
	public List<Object[]> getListProd(@QueryParam("id") String id, @QueryParam("descricao") String descricao,
			@QueryParam("precoCompra") String precoCompra, @QueryParam("precoVenda") String precoVenda,
			@QueryParam("dataDe") String dataDe, @QueryParam("dataAte") String dataAte) {
		return prodBss.getListByCond(id, descricao, precoCompra, precoVenda, dataDe, dataAte);
	}
	@GET
	@Path("/dto/{id}")
	public ProdutoDto getDTO(@PathParam("id") Integer id) {
		return prodBss.getDTO(id);
	}

	@PUT
	@Path("/create-or-update")
	public Produto create(Produto entity) {
		return prodBss.create(entity);
	}

	@DELETE
	public void delete(Integer pk) {
		prodBss.delete(pk);
	}

}
