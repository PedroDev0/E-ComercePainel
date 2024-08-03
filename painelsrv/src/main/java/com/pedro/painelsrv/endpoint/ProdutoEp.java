package com.pedro.painelsrv.endpoint;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.pedro.painelsrv.business.ProdutoBss;
import com.pedro.painelsrv.domain.Produto;

@Path("/product")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoEp {

	@EJB
	ProdutoBss prodBss;

	@POST
	@Path("/create")
	public Produto create(Produto entity) {
		return prodBss.create(entity);
	}

	@PUT
	@Path("/update")
	public Produto update(Produto entity) {
		return prodBss.update(entity);
	}
	
	@GET
	public List<Produto> getListProd(@QueryParam("id") String id, @QueryParam("descricao") String descricao,
			@QueryParam("precoCompra") String precoCompra, @QueryParam("precoVenda") String precoVenda,
			@QueryParam("dataDe") String dataDe, @QueryParam("dataAte") String dataAte) {
		return prodBss.getListByCond(id, descricao, precoCompra, precoVenda, dataDe, dataAte);
	}

	@GET
	@Path("/dto/{id}")
	public Produto getDTO(@PathParam("id") Integer id) {
		return prodBss.getDTO(id);
	}



	@DELETE
	@Path("/delete/{pk}")
	public boolean delete(@PathParam("pk") Integer pk) {
		return prodBss.delete(pk);
	}

}
