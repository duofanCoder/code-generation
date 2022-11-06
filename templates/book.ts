import { request } from "../request";

export function fetchQueryDAXIE(condition: Partial<Condition.Common>) {
	return request.post<Dto.Page<Dto.DAXIE>>("/XIAOXIE/query", condition);
}

export function fetchRemoveDAXIE(ids: number[]) {
	const searchParams = new URLSearchParams();
	ids.forEach(id => searchParams.append("primaryKeys", id.toString()));
	return request.post(`/XIAOXIE/remove?${searchParams.toString()}`);
}

export function fetchSaveDAXIE(XIAOXIE: Partial<Dto.DAXIE>) {
	return request.post("/XIAOXIE/save", XIAOXIE);
}

export function fetchUpdateDAXIE(XIAOXIE: Partial<Dto.DAXIE>) {
	return request.post("/XIAOXIE/update", XIAOXIE);
}
