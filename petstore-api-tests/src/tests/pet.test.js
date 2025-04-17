const api = require("../utils/apiClient");
const { newPet, updatedPet } = require("../data/petPayloads");

function delay(ms) {
  return new Promise(r => setTimeout(r, ms));
}

describe("PET API CRUD Tests (json‑server)", () => {
  const petId = newPet.id;

  beforeAll(async () => {
    const res = await api.post("/pet", newPet);
    // json‑server returns 201 Created, not 200
    expect(res.status).toBe(201);
    await delay(200);
  });

  afterAll(async () => {
    await api.delete(`/pet/${petId}`);
  });

  it("should retrieve the pet", async () => {
    const res = await api.get(`/pet/${petId}`);
    expect(res.status).toBe(200);
  });

  it("should update the pet", async () => {
    const res = await api.put(`/pet/${petId}`, updatedPet);
    expect(res.status).toBe(200);
  });

  it("should delete the pet", async () => {
    const res = await api.delete(`/pet/${petId}`);
    expect(res.status).toBe(200);
  });
});
