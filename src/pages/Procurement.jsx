import { useState, useEffect } from 'react';
import { Plus, Search, Eye, FileText, CheckCircle } from 'lucide-react';
import api from '../api/axios';
import './Procurement.css';

export default function Procurement() {
  const [purchaseOrders, setPurchaseOrders] = useState([]);
  const [loading, setLoading] = useState(true);
  const [showModal, setShowModal] = useState(false);
  const [vendors, setVendors] = useState([]);
  const [selectedVendor, setSelectedVendor] = useState('');
  const [creating, setCreating] = useState(false);

  useEffect(() => {
    fetchPOs();
    fetchVendors();
  }, []);

  const fetchVendors = async () => {
    try {
      const response = await api.get('/vendors');
      setVendors(response.data || []);
    } catch (error) {
      console.error("Error fetching vendors:", error);
    }
  };

  const fetchPOs = async () => {
    try {
      setLoading(true);
      const response = await api.get('/po');
      setPurchaseOrders(response.data || []);
    } catch (error) {
      console.error("Error fetching POs:", error);
    } finally {
      setLoading(false);
    }
  };

  const handleCreatePO = async (e) => {
    e.preventDefault();
    if (!selectedVendor) return;
    try {
      setCreating(true);
      await api.post(`/po/${selectedVendor}`);
      setShowModal(false);
      setSelectedVendor('');
      fetchPOs(); // refresh list
    } catch (error) {
      console.error("Error creating PO:", error);
      alert("Failed to create Purchase Order");
    } finally {
      setCreating(false);
    }
  };

  const statusBadgeClass = (status) => {
    switch (status?.toUpperCase()) {
      case 'APPROVED': return 'badge-success';
      case 'PENDING': return 'badge-warning';
      case 'REJECTED': return 'badge-danger';
      case 'DELIVERED': return 'badge-info';
      default: return 'badge-warning';
    }
  };

  return (
    <div className="page-container">
      <div className="page-header">
        <div>
          <h1 className="title-gradient" style={{ fontSize: '2rem' }}>Procurement & Purchase Orders</h1>
          <p style={{ color: 'var(--text-secondary)' }}>Manage your purchase orders, requisitions, and tracking.</p>
        </div>
        <button className="btn btn-primary" onClick={() => setShowModal(true)}>
          <Plus size={18} /> New Purchase Order
        </button>
      </div>

      <div className="glass-panel vendors-content">
        <div className="table-controls">
          <div className="search-box">
            <Search size={18} className="search-icon" />
            <input 
              type="text" 
              placeholder="Search POs..." 
              className="input-base"
              style={{ paddingLeft: '2.5rem' }}
            />
          </div>
          <div className="filters">
            <select className="input-base" style={{ width: 'auto', padding: '0.5rem' }}>
              <option value="">All Statuses</option>
              <option value="PENDING">Pending</option>
              <option value="APPROVED">Approved</option>
              <option value="DELIVERED">Delivered</option>
            </select>
          </div>
        </div>

        {loading ? (
          <div className="loading-state">Loading purchase orders...</div>
        ) : (
          <div className="table-container">
            <table className="table">
              <thead>
                <tr>
                  <th>PO Number</th>
                  <th>Vendor ID</th>
                  <th>Order Date</th>
                  <th>Amount</th>
                  <th>Status</th>
                  <th style={{ textAlign: 'right' }}>Actions</th>
                </tr>
              </thead>
              <tbody>
                {purchaseOrders.length > 0 ? purchaseOrders.map(po => (
                  <tr key={po.poId}>
                    <td style={{ fontWeight: 500, color: 'var(--primary)' }}>PO-{po.poId}</td>
                    <td>{po.vendor?.vendorName || po.vendorId || 'Unknown'}</td>
                    <td>{new Date(po.orderDate).toLocaleDateString()}</td>
                    <td style={{ fontWeight: 600 }}>${po.totalAmount?.toFixed(2)}</td>
                    <td>
                      <span className={`badge ${statusBadgeClass(po.status)}`}>
                        {po.status || 'PENDING'}
                      </span>
                    </td>
                    <td>
                      <div className="action-buttons">
                        <button className="icon-btn" title="View Details"><Eye size={18} /></button>
                        <button className="icon-btn" title="View Invoice"><FileText size={18} /></button>
                        {po.status === 'PENDING' && (
                          <button className="icon-btn" style={{ color: 'var(--secondary)' }} title="Approve">
                            <CheckCircle size={18} />
                          </button>
                        )}
                      </div>
                    </td>
                  </tr>
                )) : (
                  <tr>
                    <td colSpan="6" style={{ textAlign: 'center', padding: '3rem', color: 'var(--text-secondary)' }}>
                      No purchase orders found.
                    </td>
                  </tr>
                )}
              </tbody>
            </table>
          </div>
        )}
      </div>

      {showModal && (
        <div className="modal-overlay" onClick={() => setShowModal(false)}>
          <div className="modal-content glass-panel" onClick={e => e.stopPropagation()}>
            <div className="modal-header">
              <h2>Create Purchase Order</h2>
              <button className="icon-btn" onClick={() => setShowModal(false)}>X</button>
            </div>
            <form onSubmit={handleCreatePO} className="modal-body">
              <div className="form-group">
                <label>Select Vendor</label>
                <select 
                  className="input-base" 
                  value={selectedVendor}
                  onChange={(e) => setSelectedVendor(e.target.value)}
                  required
                >
                  <option value="">-- Choose a Vendor --</option>
                  {vendors.map(v => (
                    <option key={v.vendorId || v.id} value={v.vendorId || v.id}>
                      {v.vendorName || v.companyName}
                    </option>
                  ))}
                </select>
              </div>
              <div className="modal-footer" style={{ marginTop: '2rem', display: 'flex', justifyContent: 'flex-end', gap: '1rem' }}>
                <button type="button" className="btn btn-secondary" onClick={() => setShowModal(false)}>Cancel</button>
                <button type="submit" className="btn btn-primary" disabled={creating}>
                  {creating ? 'Creating...' : 'Create PO'}
                </button>
              </div>
            </form>
          </div>
        </div>
      )}
    </div>
  );
}
