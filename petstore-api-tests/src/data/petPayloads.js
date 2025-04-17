module.exports = {
  newPet: {
    id: 100001,
    category: { id: 1, name: "Dogs" },
    name: "Fluffy",
    photoUrls: ["http://example.com/dog.jpg"],
    tags: [{ id: 1, name: "cute" }],
    status: "available"
  },
  updatedPet: {
    id: 100001,
    category: { id: 1, name: "Dogs" },
    name: "FluffyUpdated",
    photoUrls: ["http://example.com/dog2.jpg"],
    tags: [{ id: 1, name: "friendly" }],
    status: "sold"
  }
};
